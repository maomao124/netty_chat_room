package mao.console_client.thread;

import io.netty.channel.Channel;
import lombok.SneakyThrows;
import mao.chat_room_common.message.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.thread
 * Class(类名): BizThread
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/30
 * Time(创建时间)： 23:05
 * Version(版本): 1.0
 * Description(描述)： 业务线程
 */

public class BizThread extends Thread
{
    private final Channel channel;

    private final String username;


    public BizThread(Channel channel, String username)
    {
        this.channel = channel;
        this.username = username;
        setName("BizThread");
        setDaemon(true);
    }

    @SneakyThrows
    @Override
    public void run()
    {
        System.out.println("\n\n\n\n");
        Scanner input = new Scanner(System.in);
        super.run();
        while (true)
        {
            try
            {
                System.out.println("---------------------------------------------");
                System.out.println("send [username] [content]");
                System.out.println("gsend [group name] [content]");
                System.out.println("gcreate [group name] [m1,m2,m3...]");
                System.out.println("gmembers [group name]");
                System.out.println("gjoin [group name]");
                System.out.println("gquit [group name]");
                System.out.println("ping");
                System.out.println("help");
                System.out.println("quit");
                System.out.println("---------------------------------------------");
                System.out.print("请输入以上命令：");
                String command = input.nextLine();
                String[] s = command.split(" ");

                switch (s[0])
                {
                    case "send":
                        channel.writeAndFlush(new ChatRequestMessage()
                                .setFrom(username)
                                .setTo(s[1])
                                .setContent(s[2])
                                .setSequenceId());
                        break;
                    case "gsend":
                        channel.writeAndFlush(new GroupChatRequestMessage()
                                .setFrom(username)
                                .setGroupName(s[1])
                                .setContent(s[2])
                                .setSequenceId());
                        break;
                    case "gcreate":
                        //成员列表
                        Set<String> set = new HashSet<>(Arrays.asList(s[2].split(",")));
                        set.add(username);
                        channel.writeAndFlush(new GroupCreateRequestMessage()
                                .setGroupName(s[1])
                                .setMembers(set)
                                .setSequenceId());
                        break;
                    case "gmembers":
                        channel.writeAndFlush(new GroupMembersRequestMessage()
                                .setGroupName(s[1])
                                .setSequenceId());
                        break;
                    case "gjoin":
                        channel.writeAndFlush(new GroupJoinRequestMessage()
                                .setUsername(username)
                                .setGroupName(s[1])
                                .setSequenceId());
                        break;
                    case "gquit":
                        channel.writeAndFlush(new GroupQuitRequestMessage()
                                .setUsername(username)
                                .setGroupName(s[1])
                                .setSequenceId());
                        break;
                    case "quit":
                        channel.close();
                        return;
                    case "help":
                        printHelp();
                        break;
                    case "ping":
                        long start = System.currentTimeMillis();
                        channel.writeAndFlush(new PingMessage().setRequestTime(start)
                                .setSequenceId());
                        break;
                    default:
                        continue;
                }


                System.out.println("等待服务器响应...");
                LockSupport.park();
                Thread.sleep(100);
                System.out.println();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

    }

    /**
     * 打印帮助消息
     */
    private static void printHelp()
    {

    }
}
