package mao.console_test_client.thread;

import io.netty.channel.Channel;
import lombok.SneakyThrows;
import mao.chat_room_common.message.ChatRequestMessage;
import mao.chat_room_common.message.GroupChatRequestMessage;
import mao.chat_room_common.message.PingMessage;

import java.util.Scanner;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.LockSupport;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.console_client.thread
 * Class(类名): StressTestBizThread
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/9
 * Time(创建时间)： 22:36
 * Version(版本): 1.0
 * Description(描述)： 压力测试业务线程，可以进程多开
 */

public class StressTestBizThread extends Thread
{
    private final Channel channel;

    private final String username;

    private long firstTime;

    private long previousTime;

    private long thisTime;

    private long previousCount;

    private long thisCount;


    public StressTestBizThread(Channel channel, String username)
    {
        this.channel = channel;
        this.username = username;
        setName("StressTestBizThread");
        System.out.println("压力测试");
        setDaemon(true);
    }

    @SneakyThrows
    @Override
    public void run()
    {
        System.out.println("\n\n\n\n");
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("1.单人消息压力测试");
        System.out.println("2.群聊消息压力测试");
        System.out.println("3.ping压力测试-单节点");
        System.out.println("---------------------------------------------");
        System.out.print("请输入项目序号：");
        int i = input.nextInt();
        LongAdder longAdder = new LongAdder();
        Thread thread = new Thread(new Runnable()
        {
            @SneakyThrows
            @Override
            public void run()
            {
                while (true)
                {
                    Thread.sleep(1000);
                    long sum = longAdder.sum();
                    thisTime = System.currentTimeMillis();
                    thisCount = sum;
                    long time = thisTime - previousTime;
                    long count = thisCount - previousCount;
                    previousTime = thisTime;
                    previousCount = thisCount;
                    float result = (float) (count / ((double) time / 1000));
                    float result2 = (float) (thisCount / (((double) thisTime - (double) firstTime) / 1000));
                    System.out.println("已发送：" + sum + "条，当前串行吞吐量：" +
                            result + "条/s，平均串行吞吐量：" + result2 + "条/s，计算间隔：" + time + "ms");
                }
            }
        }, "count");
        thread.setDaemon(true);

        if (i == 1)
        {
            System.out.println("单人消息压力测试");
            System.out.print("请输入接收方：");
            String to = input.next();
            System.out.print("请输入消息内容：");
            String body = input.next();
            thread.start();
            firstTime = System.currentTimeMillis();
            previousTime = firstTime;
            while (true)
            {
                channel.writeAndFlush(new ChatRequestMessage()
                        .setFrom(username)
                        .setTo(to)
                        .setContent(body)
                        .setSequenceId());
                longAdder.increment();
                LockSupport.park();
            }
        }
        else if (i == 2)
        {
            System.out.println("群聊消息压力测试");
            System.out.print("请输入群聊名称：");
            String groupName = input.next();
            System.out.print("请输入消息内容：");
            String body = input.next();
            thread.start();
            firstTime = System.currentTimeMillis();
            previousTime = firstTime;
            while (true)
            {
                channel.writeAndFlush(new GroupChatRequestMessage()
                        .setFrom(username)
                        .setGroupName(groupName)
                        .setContent(body)
                        .setSequenceId());
                longAdder.increment();
                LockSupport.park();
            }
        }
        else if (i == 3)
        {
            System.out.println("ping压力测试-单节点");
            thread.start();
            firstTime = System.currentTimeMillis();
            previousTime = firstTime;
            while (true)
            {
                long start = System.currentTimeMillis();
                channel.writeAndFlush(new PingMessage().setRequestTime(start)
                        .setSequenceId());
                longAdder.increment();
                LockSupport.park();
            }
        }
        else
        {
            System.out.println("正在退出...");
            channel.close();
        }

    }
}
