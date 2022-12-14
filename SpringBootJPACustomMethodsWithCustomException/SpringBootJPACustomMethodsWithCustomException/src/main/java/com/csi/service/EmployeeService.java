package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao EmployeeDaoImpl;

    public Employee saveData(Employee employee){
        return EmployeeDaoImpl.saveData(employee);
    }

    public Employee getDataByEmpContactNumber(long empContactNumber){
        return EmployeeDaoImpl.getDataByEmpContactNumber(empContactNumber);
    }

    public List<Employee> getDataByEmpName(String empName){
        return EmployeeDaoImpl.getDataByEmpName(empName);
    }

    public Optional<Employee> getDataById(long empId){
        return EmployeeDaoImpl.getDataById(empId);
    }

    public Employee updateData(Employee employee){
        return EmployeeDaoImpl.updateData(employee);
    }

    public List<Employee> getAllData(){
        return EmployeeDaoImpl.getAllData();
    }

    public void deleteDataById(long empId){
        EmployeeDaoImpl.deleteDataById(empId);
    }


}
