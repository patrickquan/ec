package com.yangcl.ec.api.erp.service.erp.impl;

import com.yangcl.ec.api.erp.mapper.DepartmentMapper;
import com.yangcl.ec.api.erp.service.erp.DepartmentService;
import com.yangcl.ec.common.entity.erp.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public long insert(Department department) {
        return departmentMapper.insert(department);
    }

    public long delete(long sysno) {
        return departmentMapper.delete(sysno);
    }

    public long update(Department department) {
        return departmentMapper.update(department);
    }

    public Department getBySysno(long sysno) {
        return departmentMapper.get(sysno);
    }
}
