package com.csi.controller;


import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));

    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable long empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping("/getdatabyempname/{empName}")
    public ResponseEntity<List<Employee>> getDataByEmpName(@PathVariable String empName){
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmpName(empName));
    }

    @GetMapping("/getdatabyempcontactnumber/{empContactNumber}")
    public ResponseEntity<Employee> getDataByEmpContactNumber(@PathVariable long empContactNumber){
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmpContactNumber(empContactNumber));
    }

    @PutMapping("/upadtedatabyid/{empId}")
    public ResponseEntity<Employee> updateDataById(@PathVariable long empId, @RequestBody Employee employee) throws RecordNotFoundException {
        Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()->new RecordNotFoundException("EmployeeId Does Not Exist"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpAddress(employee.getEmpAddress());
        return ResponseEntity.ok(employeeServiceImpl.updateData(employee));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
       return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @DeleteMapping("/deleteallData/{empId}")
    public ResponseEntity<String> deleteAllData(@PathVariable long empId){
       employeeServiceImpl.deleteDataById(empId);
       return ResponseEntity.ok("Data Deleted Successfully");
    }
}
