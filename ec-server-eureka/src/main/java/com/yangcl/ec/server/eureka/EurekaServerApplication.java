package com.yangcl.ec.server.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Erueka Server 注册中心Boot Start
 * Created by ASSION on 2017/8/20.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
    public static void main(String[] args){
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
