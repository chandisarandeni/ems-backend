package com.ems_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nic", unique = true, nullable = false)
    private String nic;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    private String role;

    @Column(name = "salary")
    private float salary;

    @Column(name = "hired_date")
    private LocalDate hiredDate;

    @Column(name = "resign_date")
    private LocalDate resignedDate;

    @Column(name = "department")
    private String departmentId;
}
