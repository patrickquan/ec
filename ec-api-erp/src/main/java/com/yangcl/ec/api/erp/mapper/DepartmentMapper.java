package com.yangcl.ec.api.erp.mapper;

import com.yangcl.ec.common.entity.erp.Department;

import java.util.List;

public interface DepartmentMapper {
    public long insert(Department department);
    public long delete(long sysno);
    public long update(Department department);
    public Department getBySysno(long sysno);
}
