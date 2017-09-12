package com.zjj.springboot.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Created by jinju.zeng on 2017/9/11.
 * 这个拦截器只能用来拦截MVC请求(通过DispatcherServlet)
 */
@Configuration
public class WebApplicationInterceptorConfigurer extends WebMvcConfigurerAdapter{

    @Resource(name="authInterceptor")
    private HandlerInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns("/index");
        super.addInterceptors(registry);
    }
}
