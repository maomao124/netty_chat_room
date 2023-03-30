package mao.console_client.thread;

import io.netty.channel.Channel;

import java.util.Scanner;

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


    public BizThread(Channel channel)
    {
        this.channel = channel;
        setName("BizThread");
        setDaemon(true);
    }

    @Override
    public void run()
    {
        Scanner input = new Scanner(System.in);
        super.run();
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
        System.out.print("请输入：");

    }
}
