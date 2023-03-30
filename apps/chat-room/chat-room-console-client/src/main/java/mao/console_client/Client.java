package mao.console_client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_client_api.config.ClientConfig;
import mao.chat_room_client_api.protocol.ClientMessageCodecSharable;
import mao.chat_room_common.message.LoginRequestMessage;
import mao.chat_room_common.message.PingMessage;
import mao.chat_room_common.message.PongMessage;
import mao.chat_room_common.message.RegisterRequestMessage;
import mao.chat_room_common.protocol.ProcotolFrameDecoder;
import mao.console_client.handler.LoginResponseMessageHandler;
import mao.console_client.handler.PingResponseMessageHandler;
import mao.console_client.handler.RegisterResponseMessageHandler;
import mao.console_client.thread.LoginAndRegisterThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

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

    private static Thread thread;
    private static Channel channel;

    public static Thread getThread()
    {
        return thread;
    }

    public static void setThread(Thread thread)
    {
        Client.thread = thread;
    }

    public static Channel getChannel()
    {
        return channel;
    }

    public static void setChannel(Channel channel)
    {
        Client.channel = channel;
    }

    public static void main(String[] args)
    {
        NioEventLoopGroup group = new NioEventLoopGroup();
        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
        ClientMessageCodecSharable clientMessageCodecSharable = new ClientMessageCodecSharable();

        PingResponseMessageHandler pingResponseMessageHandler = new PingResponseMessageHandler();
        LoginResponseMessageHandler loginResponseMessageHandler = new LoginResponseMessageHandler();
        RegisterResponseMessageHandler registerResponseMessageHandler = new RegisterResponseMessageHandler();

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
                                .addLast(registerResponseMessageHandler);
                    }
                }).connect(new InetSocketAddress(ClientConfig.getServerIp(), ClientConfig.getServerPort()));

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

    }
}
