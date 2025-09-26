package com.ems_backend.repository;

import com.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findByNic(String nic);

    List<Employee> findByDepartmentId(String departmentId);

    @Query(value = "SELECT e.employeeId FROM Employee e ORDER BY e.employeeId DESC")
    List<String> findAllEmployeeIdsDesc();
}
