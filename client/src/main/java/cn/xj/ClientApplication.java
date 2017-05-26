package cn.xj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by Welink on 2017/5/12.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ClientApplication {

    private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        logger.info("client start up");
    }

    //增加一个SpringMVC的DispatcherServlet，接收前台/api开头的请求
    @Bean
    public ServletRegistrationBean ApiServletBean(WebApplicationContext wac) {
        DispatcherServlet servlet = new DispatcherServlet(wac);
        ServletRegistrationBean bean = new ServletRegistrationBean(servlet, "/api/*");
        bean.setName("ApiServlet");
        return bean;
    }

}
