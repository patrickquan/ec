package com.yangcl.ec.api.erp.service.erp.impl;

import com.yangcl.ec.api.erp.mapper.UserMapper;
import com.yangcl.ec.api.erp.service.erp.UserService;
import com.yangcl.ec.common.entity.erp.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public long insert(User user) {
        return userMapper.insert(user);
    }

    public long delete(long sysno) {
        return userMapper.delete(sysno);
    }

    public long update(User user) {
        return userMapper.update(user);
    }

    public User get(long sysno) {
        return userMapper.get(sysno);
    }

    public List<User> select(Map<String, Object> condition) {
        return userMapper.select(condition);
    }

    public User getByUsernameAndPassword(String loginName, String loginPwd) {
        Map<String,Object> condition=new HashMap<String,Object>();
        condition.put("loginName",loginName);
        condition.put("loginPwd",loginPwd);
        condition.put("status",1);
        condition.put("isDel",0);
        List<User> users=userMapper.select(condition);
        if(users.size()>0){
            return users.get(0);
        }else{
            return null;
        }
    }
}
