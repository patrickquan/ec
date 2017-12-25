package com.yangcl.ec.api.erp.controller;

import com.github.pagehelper.PageInfo;
import com.yangcl.ec.api.erp.service.erp.DepartmentService;
import com.yangcl.ec.api.erp.service.erp.EmployeeService;
import com.yangcl.ec.common.entity.erp.Department;
import com.yangcl.ec.common.entity.erp.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/employee/get",method = RequestMethod.GET)
    public Employee getEmployee(){
        Employee employee=employeeService.get(1);
        return employee;
    }

    @RequestMapping(value = "/employee/list",method = RequestMethod.GET)
    public PageInfo<Employee> getEmployees(){
        Map<String,Object> where=new HashMap<String,Object>();
        PageInfo<Employee> employees=employeeService.select(where);
        return employees;
    }

    @RequestMapping(value = "/department/get",method = RequestMethod.GET)
    public Department getDepartment(){
        return departmentService.getBySysno(2);
    }
}
