package com.zjj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by jinju.zeng on 2017/7/30.
 */
@SpringBootApplication
public class SpringApplicationStart {



    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringApplicationStart.class,args);
    }
}
