package com.it.personalblog1_0.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/22 11:28
 */
@Configuration()
public class DruidConfig {

    //配置自己的数据源属性
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
       return new DruidDataSource();
    }
    //配置Druid的监控
    /**1、配置一个管理后台的Servlet*/
    @Bean
    public ServletRegistrationBean setViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap();
        initParams.put("loginUsername","Lonson");
        initParams.put("loginPassword","123456");
        //默认允许全部访问
        initParams.put("allow","");
        //initParams.put("deny","");//拒绝谁访问
        bean.setInitParameters(initParams);
        return bean;
    }

    /**配置web监控filter*/
    @Bean
    public FilterRegistrationBean webStatFilter(){

        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
