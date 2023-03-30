package mao.console_client.thread;

import io.netty.channel.Channel;
import lombok.SneakyThrows;
import mao.chat_room_common.message.LoginRequestMessage;
import mao.chat_room_common.message.PingMessage;
import mao.chat_room_common.message.RegisterRequestMessage;

import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.thread
 * Class(类名): LoginAndRegisterThread
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 23:00
 * Version(版本): 1.0
 * Description(描述)： 登录和注册线程
 */

public class LoginAndRegisterThread extends Thread
{
    private final Channel channel;

    public LoginAndRegisterThread(Channel channel)
    {
        this.channel = channel;
        setName("loginAndRegisterThread");
        setDaemon(true);
    }


    @SneakyThrows
    @Override
    public void run()
    {
        super.run();
        Scanner input = new Scanner(System.in);

        while (true)
        {
            System.out.println("------------------------------");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.ping");
            System.out.println("4.退出");
            System.out.println("------------------------------");
            System.out.print("请输入：");
            String next = input.next();
            if ("1".equals(next))
            {
                System.out.print("请输入用户名：");
                String username = input.next();
                System.out.print("请输入密码：");
                String password = input.next();
                channel.writeAndFlush(new LoginRequestMessage()
                        .setUsername(username)
                        .setPassword(password)
                        .setSequenceId());
            }
            else if ("2".equals(next))
            {
                System.out.print("请输入用户名：");
                String username = input.next();
                System.out.print("请输入密码：");
                String password = input.next();
                channel.writeAndFlush(new RegisterRequestMessage()
                        .setUsername(username)
                        .setPassword(password)
                        .setSequenceId());
            }
            else if ("3".equals(next))
            {
                long start = System.currentTimeMillis();
                channel.writeAndFlush(new PingMessage().setRequestTime(start)
                        .setSequenceId());
            }
            else if ("4".equals(next))
            {
                System.out.println("正在关闭...");
                channel.close();
            }
            else
            {
                continue;
            }
            System.out.println("等待服务器响应...");
            LockSupport.park();
            Thread.sleep(100);
            System.out.println();
        }
    }
}
