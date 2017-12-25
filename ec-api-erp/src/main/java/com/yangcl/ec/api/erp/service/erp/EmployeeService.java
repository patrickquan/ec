package com.yangcl.ec.api.erp.service.erp;

import com.yangcl.ec.common.entity.erp.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> selectByDepartmentSysNo(long sysno);
    public Employee selectBySysno(long sysno);
    public List<Employee> selectByParams(Employee employee,int pageNo, int pageSize);
}
