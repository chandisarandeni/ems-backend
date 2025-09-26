package com.ems_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String employeeId;
    private String name;
    private String nic;
    private String email;
    private String phone;
    private String gender;
    private String role;
    private double salary;
    private Date hiredDate;
    private Date resignedDate;
    private String departmentId;
}
