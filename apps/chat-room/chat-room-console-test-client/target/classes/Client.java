package mao.console_test_client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import mao.chat_room_client_api.config.ClientConfig;
import mao.chat_room_client_api.entity.R;
import mao.chat_room_client_api.net.RestfulHTTP;
import mao.chat_room_client_api.protocol.ClientMessageCodecSharable;
import mao.chat_room_common.entity.Server;
import mao.chat_room_common.protocol.ProcotolFrameDecoder;
import mao.console_test_client.app.MainApplication;
import mao.console_test_client.handler.*;
import mao.console_test_client.thread.LoginAndRegisterThread;

import java.awt.*;
import java.net.InetSocketAddress;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client
 * Class(类名): Client
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 21:19
 * Version(版本): 1.0
 * Description(描述)： 客户端
 */


public class Client
{

    private static volatile Thread thread;
    private static volatile Channel channel;

    public static Thread getThread()
    {
        return thread;
    }

    public static void setThread(Thread thread)
    {
        StressTestClient.thread = thread;
    }

    public static Channel getChannel()
    {
        return channel;
    }

    public static void setChannel(Channel channel)
    {
        StressTestClient.channel = channel;
    }

    public static void main(String[] args)
    {
        RestfulHTTP restfulHTTP = MainApplication.getRestfulHTTP();
        System.out.println("服务器URL：" + ClientConfig.getServerUrl());
        System.out.println("正在等待服务器响应...");
        R<String> r = restfulHTTP.GET(R.class, ClientConfig.getServerUrl(), null, null);
        if (r.getIsError())
        {
            //错误
            System.out.println("获取netty服务时错误：" + r.getMsg());
            Toolkit.getDefaultToolkit().beep();
            return;
        }
        Server server = r.getData(Server.class);
        String ip = server.getIp();
        Integer port = server.getPort();
        System.out.println(ip + ":" + port);

        NioEventLoopGroup group = new NioEventLoopGroup();
        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
        ClientMessageCodecSharable clientMessageCodecSharable = new ClientMessageCodecSharable();

        PingResponseMessageHandler pingResponseMessageHandler = new PingResponseMessageHandler();
        LoginResponseMessageHandler loginResponseMessageHandler = new LoginResponseMessageHandler();
        RegisterResponseMessageHandler registerResponseMessageHandler = new RegisterResponseMessageHandler();
        ChatResponseMessageHandler chatResponseMessageHandler = new ChatResponseMessageHandler();
        GroupChatResponseMessageHandler groupChatResponseMessageHandler = new GroupChatResponseMessageHandler();
        GroupCreateResponseMessageHandler groupCreateResponseMessageHandler = new GroupCreateResponseMessageHandler();
        GroupMembersResponseMessageHandler groupMembersResponseMessageHandler = new GroupMembersResponseMessageHandler();
        GroupJoinResponseMessageHandler groupJoinResponseMessageHandler = new GroupJoinResponseMessageHandler();
        GroupQuitResponseMessageHandler groupQuitResponseMessageHandler = new GroupQuitResponseMessageHandler();

        Bootstrap bootstrap = new Bootstrap();
        ChannelFuture channelFuture = bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>()
                {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception
                    {
                        ch.pipeline().addLast(LOGGING_HANDLER)
                                .addLast(new ProcotolFrameDecoder())
                                .addLast(clientMessageCodecSharable)
                                .addLast(pingResponseMessageHandler)
                                .addLast(loginResponseMessageHandler)
                                .addLast(registerResponseMessageHandler)
                                .addLast(chatResponseMessageHandler)
                                .addLast(groupChatResponseMessageHandler)
                                .addLast(groupCreateResponseMessageHandler)
                                .addLast(groupMembersResponseMessageHandler)
                                .addLast(groupJoinResponseMessageHandler)
                                .addLast(groupQuitResponseMessageHandler);
                    }
                }).connect(new InetSocketAddress(ip, port));

        channel = channelFuture.channel();

        thread = new LoginAndRegisterThread(channel);

        channelFuture.addListener(new GenericFutureListener<Future<? super Void>>()
        {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception
            {
                if (future.isSuccess())
                {
                    System.out.println("客户端启动成功");
                    thread.start();
                }
                else
                {
                    String message = future.cause().getMessage();
                    System.out.println("错误：" + message);
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        channel.closeFuture().addListener(new GenericFutureListener<Future<? super Void>>()
        {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception
            {
                group.shutdownGracefully();
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    channel.close();
                }
                catch (Exception ignored)
                {

                }
                try
                {
                    group.shutdownGracefully();
                }
                catch (Exception ignored)
                {

                }
            }
        }));

    }
}
