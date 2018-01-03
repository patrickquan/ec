package com.yangcl.ec.service.authentication.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 在线帐户仓库工厂
 */
public class AccountFactory {

    //在线帐户仓库接口
    private AccountRepository accountRepository;

    //根据名称实例化不同的仓库实现，默认用Memory实现
    public AccountRepository getInstance(String accountRepositoryName){
        //根据配置创建不同的在线会员仓库实现对象
        if(accountRepositoryName.equals("MemoryAccountRepositoryImpl")){
            return new MemoryAccountRepositoryImpl();
        }else if(accountRepositoryName.equals("RedisAccountRepositoryImpl")){
            return new RedisAccountRepositoryImpl();
        }else if(accountRepositoryName.equals("MySQLAccountRepositoryImpl")){
            return new MySQLAccountRepositoryImpl();
        }else{
            return new MemoryAccountRepositoryImpl();
        }
    }
}
