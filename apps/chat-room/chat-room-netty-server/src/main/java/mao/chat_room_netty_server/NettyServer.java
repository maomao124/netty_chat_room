package mao.chat_room_netty_server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_common.protocol.ProcotolFrameDecoder;
import mao.chat_room_netty_server.handler.*;
import mao.chat_room_netty_server.producer.ServerProducer;
import mao.chat_room_netty_server.service.RedisService;
import mao.chat_room_server_api.config.ServerConfig;
import mao.chat_room_server_api.protocol.ServerMessageCodecSharable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.concurrent.locks.LockSupport;


/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server
 * Class(类名): NettyServer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 21:18
 * Version(版本): 1.0
 * Description(描述)： netty服务器初始化
 */

@Slf4j
@Component
public class NettyServer implements CommandLineRunner
{

    @Resource
    private ServerMessageCodecSharable serverMessageCodecSharable;

    @Resource
    private ServerConfig serverConfig;

    /**
     * 协议帧解码器，这里不能共用
     */
    @Resource
    private ProcotolFrameDecoder procotolFrameDecoder;

    @Resource
    private ChatRequestMessageHandler chatRequestMessageHandler;

    @Resource
    private GroupChatRequestMessageHandler groupChatRequestMessageHandler;

    @Resource
    private GroupCreateRequestMessageHandler groupCreateRequestMessageHandler;

    @Resource
    private GroupJoinRequestMessageHandler groupJoinRequestMessageHandler;

    @Resource
    private GroupMembersRequestMessageHandler groupMembersRequestMessageHandler;

    @Resource
    private GroupQuitRequestMessageHandler groupQuitRequestMessageHandler;

    @Resource
    private LoginRequestMessageHandler loginRequestMessageHandler;

    @Resource
    private RegisterRequestMessageHandler registerRequestMessageHandler;

    @Resource
    private QuitHandler quitHandler;

    @Resource
    private PingMessageHandler pingMessageHandler;

    @Resource
    private ServerProducer serverProducer;

    @Resource
    private RedisService redisService;

    @Value("${server.port}")
    private String port;

    /**
     * 运行,禁止长时间阻塞此线程
     *
     * @param args 参数
     * @throws Exception 异常
     */
    @Override
    public void run(String... args) throws Exception
    {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);

        try
        {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            Channel channel = serverBootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>()
                    {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception
                        {
                            ch.pipeline().addLast(LOGGING_HANDLER)
                                    .addLast(new ProcotolFrameDecoder())
                                    .addLast(serverMessageCodecSharable)
                                    .addLast(chatRequestMessageHandler)
                                    .addLast(groupChatRequestMessageHandler)
                                    .addLast(groupCreateRequestMessageHandler)
                                    .addLast(groupJoinRequestMessageHandler)
                                    .addLast(groupMembersRequestMessageHandler)
                                    .addLast(groupQuitRequestMessageHandler)
                                    .addLast(loginRequestMessageHandler)
                                    .addLast(registerRequestMessageHandler)
                                    .addLast(pingMessageHandler)
                                    .addLast(quitHandler);
                        }
                    }).bind(serverConfig.getServerPort()).sync().channel();
            log.info("Netty服务器启动成功");
            serverProducer.sendNettyServerUpdateMessage();
            channel.closeFuture().addListener(new GenericFutureListener<Future<? super Void>>()
            {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception
                {
                    log.info("正在关闭服务器...");
                    close(boss, worker);
                }
            });
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
            {
                @SneakyThrows
                @Override
                public void run()
                {
                    log.info("正在关闭服务器...");
                    serverProducer.sendNettyServerUpdateMessage();
                    String hostAddress = InetAddress.getLocalHost().getHostAddress();
                    String host = hostAddress + ":" + port;
                    redisService.unbindGroup(host);
                    close(boss, worker);
                }
            }));
        }
        catch (Exception e)
        {
            log.info("Netty服务器启动失败");
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭
     *
     * @param boss   NioEventLoopGroup
     * @param worker NioEventLoopGroup
     */
    private void close(NioEventLoopGroup boss, NioEventLoopGroup worker)
    {
        try
        {
            boss.shutdownGracefully();
        }
        catch (Exception ignored)
        {

        }
        try
        {
            worker.shutdownGracefully();
        }
        catch (Exception ignored)
        {

        }
    }


    @PostConstruct
    public void init()
    {
        log.info("初始化 NettyServer");
    }
}
