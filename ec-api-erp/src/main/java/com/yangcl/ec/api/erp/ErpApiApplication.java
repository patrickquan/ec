package com.yangcl.ec.api.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.yangcl.ec.api.erp.mapper")
public class ErpApiApplication {
    public static void main(String[] args){
        SpringApplication.run(ErpApiApplication.class,args);
    }
}
