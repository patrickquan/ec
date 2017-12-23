package com.yangcl.ec.api.erp.service.erp;

import com.yangcl.ec.api.erp.mapper.UserMapper;
import com.yangcl.ec.common.entity.erp.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserEntity getByKey(long sysno) {
        return userMapper.getByKey(sysno);
    }
}
