package com.springboot.springboot6.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jay.wang
 * @create 2019-08-05-14:08
 **/
@Configuration
public class DruidConfig {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource()
    {
        return new DruidDataSource();
    }


    @Bean
    public ServletRegistrationBean startDruidSerlvet()
    {
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        Map<String,String> init=new HashMap<>();
        init.put("loginUsername","admin");
        init.put("loginPassword","123456");
        init.put("allow","");
        init.put("deny","192.168.1.120");

        servletRegistrationBean.setInitParameters(init);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean webstatServlet()
    {
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new WebStatFilter());

        Map<String,String> init=new HashMap<>();

        init.put("exclusions","*.js,*.css,/druid/*");

        filterRegistrationBean.setInitParameters(init);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        return filterRegistrationBean;
    }





}
