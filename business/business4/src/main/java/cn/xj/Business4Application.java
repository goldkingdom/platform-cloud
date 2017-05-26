package cn.xj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Business4Application {

    public static void main(String[] args) {
        SpringApplication.run(Business4Application.class, args);
    }

}
