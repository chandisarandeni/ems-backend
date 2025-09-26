package com.ems_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id", length = 6)
    private String employeeId; // EMP001, EMP002, etc.

    @Column(name = "name")
    private String name;

    @Column(name = "nic", unique = true)
    private String nic;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "role")
    private String role;

    @Column(name = "salary")
    private double salary;

    @Column(name = "hired_date")
    private Date hiredDate;

    @Column(name = "resigned_date")
    private Date resignedDate;

    @Column(name = "department_id")
    private String departmentId;
}
