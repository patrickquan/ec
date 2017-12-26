package com.yangcl.ec.api.erp.service.erp;

import com.yangcl.ec.common.entity.erp.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    public long insert(Role role);
    public long delete(long sysno);
    public long update(Role role);
    public Role get(long sysno);
    public List<Role> select(Map<String,Object> condition);
    public List<Role> selectByUserSysno(long sysno);
    public List<Role> selectByDepartmentSysno(long sysno);
}
