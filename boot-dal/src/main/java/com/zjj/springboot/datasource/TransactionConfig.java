package com.zjj.springboot.datasource;

import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by jinju.zeng on 2017/9/14.
 */
@Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY) //开启事物默认使用代理的方式，等效于<tx:annotation-driven />
public class TransactionConfig {

    @Resource(name="druidDataSource")
    private DataSource dataSource;

    /**
     * 使用DataSourceTransactionManager事物处理器来管理事物
     * (当有多个事物源的时候，通过制定不同的name来设置多个事物源)
     * @return
     */
    @Bean(name="txManager1")
    public PlatformTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public TransactionAutoConfiguration.TransactionTemplateConfiguration transactionTemplateConfiguration(){
        return new TransactionAutoConfiguration.TransactionTemplateConfiguration(dataSourceTransactionManager());
    }

}
