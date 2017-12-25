package com.yangcl.ec.api.erp.service.erp;

import com.yangcl.ec.common.entity.erp.Department;

public interface DepartmentService {
    public long insert(Department department);
    public long delete(long sysno);
    public long update(Department department);
    public Department getBySysno(long sysno);
}
