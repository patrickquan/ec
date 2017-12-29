package com.yangcl.ec.api.erp.service.erp;

import com.yangcl.ec.common.entity.erp.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public long insert(User user);
    public long delete(long sysno);
    public long update(User user);
    public User get(long sysno);
    public List<User> select(Map<String,Object> condition);
    public User getByUsernameAndPassword(String loginName,String loginPwd);
}
