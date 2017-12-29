package com.yangcl.ec.api.erp.service.erp;

import com.yangcl.ec.common.entity.erp.domain.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public long insert(Department department);
    public long delete(long sysno);
    public long update(Department department);
    public Department get(long sysno);
    public List<Department> select(Map<String,Object> condition);
}
