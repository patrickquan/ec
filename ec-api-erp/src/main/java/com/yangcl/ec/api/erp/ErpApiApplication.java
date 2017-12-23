package com.yangcl.ec.api.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrixDashboard
@MapperScan("com.yangcl.ec.api.erp.mapper")
public class ErpApiApplication {
    public static void main(String[] args){
        SpringApplication.run(ErpApiApplication.class,args);
    }
}
