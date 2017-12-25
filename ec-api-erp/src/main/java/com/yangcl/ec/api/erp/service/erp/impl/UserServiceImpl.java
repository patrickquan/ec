package com.yangcl.ec.api.erp.service.erp.impl;

import com.yangcl.ec.api.erp.mapper.UserMapper;
import com.yangcl.ec.api.erp.service.erp.UserService;
import com.yangcl.ec.common.entity.erp.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value="userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 36000,rollbackFor = Exception.class)
    public User getByKey(long sysno) {
        return userMapper.getByKey(sysno);
    }
}
