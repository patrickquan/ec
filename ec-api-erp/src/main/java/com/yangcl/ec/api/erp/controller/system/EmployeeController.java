package com.yangcl.ec.api.erp.controller.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yangcl.ec.api.erp.service.erp.EmployeeService;
import com.yangcl.ec.common.entity.erp.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public Employee getEmployee(long sysno){
        return employeeService.get(sysno);
    }

    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    public PageInfo<Employee> getEmployeeList(@RequestParam(value = "employeename",required = false) String employeeName,
                                              @RequestParam(value = "pageNo",required = false) Integer pageNo,
                                              @RequestParam(value = "pageSize",required = false) Integer pageSize){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?10:pageSize;
        Map<String,Object> where=new HashMap<String,Object>();
        where.put("pageNo",pageNo);
        where.put("pageSize",pageSize);
        if(employeeName!=null && employeeName!=""){
            where.put("employeeName",employeeName);
        }
        return employeeService.select(where);
    }
}
