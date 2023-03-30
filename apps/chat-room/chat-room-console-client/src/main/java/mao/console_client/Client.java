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
import lombok.extern.slf4j.Slf4j;
import mao.chat_room_client_api.config.ClientConfig;
import mao.chat_room_client_api.protocol.ClientMessageCodecSharable;
import mao.chat_room_common.protocol.ProcotolFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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
    public static void main(String[] args)
    {
        NioEventLoopGroup group = new NioEventLoopGroup();
        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
        ClientMessageCodecSharable clientMessageCodecSharable = new ClientMessageCodecSharable();

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
                                .addLast(new ChannelInboundHandlerAdapter()
                                {
                                    @Override
                                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
                                    {
                                        try
                                        {
                                            ByteBuf byteBuf = (ByteBuf) msg;
                                            String json = byteBuf.toString(StandardCharsets.UTF_8);
                                            System.out.println(json);
                                        }
                                        catch (Exception e)
                                        {
                                            e.printStackTrace();
                                        }
                                        super.channelRead(ctx, msg);
                                    }

                                    @Override
                                    public void channelInactive(ChannelHandlerContext ctx) throws Exception
                                    {
                                        System.out.println("连接已经断开");
                                    }

                                    // 在出现异常时触发
                                    @Override
                                    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
                                            throws Exception
                                    {
                                        System.out.println(cause.getMessage());
                                        System.out.println("连接已经断开");
                                    }
                                });
                    }
                }).connect(new InetSocketAddress(ClientConfig.getServerIp(), ClientConfig.getServerPort()));

        Channel channel = channelFuture.channel();

        Scanner input = new Scanner(System.in);

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    System.out.println("------------------------------");
                    System.out.println("1.登录");
                    System.out.println("2.注册");
                    System.out.println("3.ping");
                    System.out.println("4.退出");
                    System.out.println("------------------------------");
                    System.out.print("请输入");
                    String next = input.next();
                    if ("1".equals(next))
                    {
                        System.out.print("请输入用户名：");
                        String username = input.next();
                        System.out.print("请输入密码：");
                        String password = input.next();
                    }
                    else if ("2".equals(next))
                    {
                        System.out.print("请输入用户名：");
                        String username = input.next();
                        System.out.print("请输入密码：");
                        String password = input.next();
                    }
                    else if ("3".equals(next))
                    {
                        System.out.println("正在关闭...");
                        channel.close();
                    }
                    else
                    {

                    }
                    System.out.println();
                }
            }
        }, "login");

        thread.setDaemon(true);

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
