package com.csi.repo;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    public List<Employee> getDataByEmpName(String empName);

    public Employee getDataByEmpContactNumber(long empContactNumber);


}
