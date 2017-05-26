package cn.xj;

import cn.xj.common.annotation.Model;
import cn.xj.common.container.ContextContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by Welink on 2017/5/25.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Business1Application {

    @Autowired
    private ContextContainer container;

    private final Logger logger = LoggerFactory.getLogger(Business1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Business1Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            String[] beanNames = context.getBeanNamesForAnnotation(Model.class);
            for (String name : beanNames) {
                logger.info("initialize container for: " + name);
                container.loadContext(name.substring(0, 1).toUpperCase() + name.substring(1));
            }
        };
    }

}
