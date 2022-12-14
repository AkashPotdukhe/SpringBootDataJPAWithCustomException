package com.csi.dao;


import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDao {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee saveData(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public Employee getDataByEmpContactNumber(long empContactNumber){
        return employeeRepoImpl.getDataByEmpContactNumber(empContactNumber);
    }

    public List<Employee> getDataByEmpName(String empName){
        return employeeRepoImpl.getDataByEmpName(empName);
    }

    public Optional<Employee> getDataById(long empId){
        return employeeRepoImpl.findById(empId);
    }

    public Employee updateData(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public List<Employee> getAllData(){
        return employeeRepoImpl.findAll();
    }

    public void deleteDataById(long empId){
        employeeRepoImpl.deleteById(empId);
    }

}
