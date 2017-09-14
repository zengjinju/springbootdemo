package com.zjj.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by jinju.zeng on 2017/7/30.
 */
@SpringBootApplication
@EnableTransactionManagement //开启事物默认使用代理的方式，等效于<tx:annotation-driven />
public class SpringApplicationStart {

    @Resource(name="druidDataSource")
    private DataSource dataSource;

    /**
     * 使用DataSourceTransactionManager事物处理器来管理事物
     * (当有多个事物源的时候，通过制定不同的name来设置多个事物源)
     * @return
     */
    @Bean(name="transaction1")
    public PlatformTransactionManager platformTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationStart.class, args);
    }
}
