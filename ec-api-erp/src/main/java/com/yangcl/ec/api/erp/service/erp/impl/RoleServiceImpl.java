package com.yangcl.ec.api.erp.service.erp.impl;

import com.yangcl.ec.api.erp.mapper.RoleMapper;
import com.yangcl.ec.api.erp.service.erp.RoleService;
import com.yangcl.ec.common.entity.erp.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public long insert(Role role) {
        return roleMapper.insert(role);
    }

    public long delete(long sysno) {
        return roleMapper.delete(sysno);
    }

    public long update(Role role) {
        return roleMapper.update(role);
    }

    public Role get(long sysno) {
        return roleMapper.get(sysno);
    }

    public List<Role> select(Map<String, Object> condition) {
        return roleMapper.select(condition);
    }

    public List<Role> selectByUserSysno(long sysno) {
        return selectByUserSysno(sysno);
    }

    public List<Role> selectByDepartmentSysno(long sysno) {
        return selectByDepartmentSysno(sysno);
    }
}
