package mao.chat_room_netty_server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.config
 * Class(类名): SpringAsyncConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/9
 * Time(创建时间)： 20:45
 * Version(版本): 1.0
 * Description(描述)： Async注解配置，将来可以放配置文件里
 */

@Slf4j
@EnableAsync
@Configuration
public class SpringAsyncConfig implements AsyncConfigurer
{
    @Override
    public Executor getAsyncExecutor()
    {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.initialize();
        //核心线程80
        threadPoolTaskExecutor.setCorePoolSize(80);
        //20个救急线程
        threadPoolTaskExecutor.setMaxPoolSize(100);
        //队列容量为200
        threadPoolTaskExecutor.setQueueCapacity(200);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler()
        {
            /**
             * 拒绝执行处理
             *
             * @param r        任务
             * @param executor 线程池
             */
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
            {
                log.warn("触发线程池拒绝策略！Async注解线程池 ，任务构建新线程运行");
                new Thread(r).start();
            }
        });
        return threadPoolTaskExecutor;
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 SpringAsyncConfig");
    }
}
