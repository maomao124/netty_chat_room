package mao.chat_room_netty_server.config;

import cn.hutool.core.util.ArrayUtil;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.p6spy.engine.spy.P6DataSource;
import lombok.extern.slf4j.Slf4j;
import mao.tools_databases.datasource.BaseDatabaseConfiguration;
import mao.tools_databases.properties.DatabaseProperties;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_netty_server.config
 * Class(类名): DataBaseConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 22:09
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
@MapperScan(basePackages = {"mao.chat_room_netty_server.mapper",},
        sqlSessionFactoryRef = DataBaseConfig.DATABASE_PREFIX + "SqlSessionFactory")
@EnableConfigurationProperties({DatabaseProperties.class, MybatisPlusProperties.class})
public class DataBaseConfig extends BaseDatabaseConfiguration
{
    /**
     * 每个数据源配置不同即可
     */
    final static String DATABASE_PREFIX = "master";

    /**
     * 数据库配置
     *
     * @param properties                              属性
     * @param databaseProperties                      数据库属性
     * @param interceptorsProvider                    拦截器供应商
     * @param typeHandlersProvider                    类型处理程序提供者
     * @param languageDriversProvider                 语言驱动程序提供商
     * @param resourceLoader                          资源加载器
     * @param databaseIdProvider                      数据库id提供商
     * @param configurationCustomizersProvider        配置定制提供者
     * @param mybatisPlusPropertiesCustomizerProvider mybatis +属性编辑器提供者
     * @param applicationContext                      应用程序上下文
     */
    public DataBaseConfig(MybatisPlusProperties properties,
                                 DatabaseProperties databaseProperties,
                                 ObjectProvider<Interceptor[]> interceptorsProvider,
                                 ObjectProvider<TypeHandler[]> typeHandlersProvider,
                                 ObjectProvider<LanguageDriver[]> languageDriversProvider,
                                 ResourceLoader resourceLoader,
                                 ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                 ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
                                 ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider,
                                 ApplicationContext applicationContext)
    {
        super(properties, databaseProperties, interceptorsProvider, typeHandlersProvider,
                languageDriversProvider, resourceLoader, databaseIdProvider,
                configurationCustomizersProvider, mybatisPlusPropertiesCustomizerProvider, applicationContext);
    }

    @Bean(DATABASE_PREFIX + "SqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier(DATABASE_PREFIX + "SqlSessionFactory") SqlSessionFactory sqlSessionFactory)
    {
        ExecutorType executorType = this.properties.getExecutorType();
        if (executorType != null)
        {
            return new SqlSessionTemplate(sqlSessionFactory, executorType);
        }
        else
        {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    /**
     * 数据源信息
     *
     * @return {@link DataSource}
     */
    @Bean(name = DATABASE_PREFIX + "DruidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 数据源
     *
     * @param dataSource 数据源
     * @return {@link DataSource}
     */
    @Bean(name = DATABASE_PREFIX + "DataSource")
    public DataSource dataSource(@Qualifier(DATABASE_PREFIX + "DruidDataSource") DataSource dataSource)
    {
        if (ArrayUtil.contains(DEV_PROFILES, this.profiles))
        {
            return new P6DataSource(dataSource);
        }
        else
        {
            return dataSource;
        }
    }

    /**
     * mybatis Sql Session 工厂
     *
     * @param dataSource 数据源
     * @return {@link SqlSessionFactory}
     * @throws Exception 异常
     */
    @Bean(DATABASE_PREFIX + "SqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier(DATABASE_PREFIX + "DataSource") DataSource dataSource)
            throws Exception
    {
        return super.sqlSessionFactory(dataSource);
    }

    /**
     * 数据源事务管理器
     *
     * @param dataSource 数据源
     * @return {@link DataSourceTransactionManager}
     */
    @Bean(name = DATABASE_PREFIX + "TransactionManager")
    public DataSourceTransactionManager dsTransactionManager(@Qualifier(DATABASE_PREFIX + "DataSource") DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 事务拦截器
     *
     * @param transactionManager 事务管理器
     * @return {@link TransactionInterceptor}
     */
    @Bean(DATABASE_PREFIX + "TransactionInterceptor")
    public TransactionInterceptor transactionInterceptor(@Qualifier(DATABASE_PREFIX + "TransactionManager") PlatformTransactionManager transactionManager)
    {
        return new TransactionInterceptor(transactionManager, this.transactionAttributeSource());
    }

    /**
     * 事务 Advisor
     *
     * @param transactionManager 事务管理器
     * @param ti                 TransactionInterceptor
     * @return {@link Advisor}
     */
    @Bean(DATABASE_PREFIX + "Advisor")
    public Advisor getAdvisor(@Qualifier(DATABASE_PREFIX + "TransactionManager") PlatformTransactionManager transactionManager, @Qualifier(DATABASE_PREFIX + "TransactionInterceptor") TransactionInterceptor ti)
    {
        return super.txAdviceAdvisor(ti);
    }


    @PostConstruct
    public void init()
    {
        log.info("初始化 DatabaseConfig");
    }
}
