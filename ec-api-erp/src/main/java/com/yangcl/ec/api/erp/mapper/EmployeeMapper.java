package com.yangcl.ec.api.erp.mapper;

import com.yangcl.ec.common.entity.erp.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    public long insert(Employee employee);
    public long delete(long sysno);
    public long update(Employee employee);
    public Employee get(long sysno);
    public List<Employee> select(Map<String,Object> condition);
    public List<Employee> selectByDepartmentSysNo(long sysno);

}
