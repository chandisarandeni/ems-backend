package com.ems_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int employeeId;
    private String name;
    private String nic;
    private String email;
    private String gender;
    private String phone;
    private String role;
    private float salary;
    private LocalDate hiredDate;
    private LocalDate resignedDate;
    private String departmentId;
}
