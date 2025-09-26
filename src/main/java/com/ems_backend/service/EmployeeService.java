package com.ems_backend.service;

import com.ems_backend.dto.EmployeeDTO;
import com.ems_backend.entity.Employee;
import com.ems_backend.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Generate Employee ID EMP001, EMP002, ...
    private String generateEmployeeId() {
        List<String> ids = employeeRepository.findAllEmployeeIdsDesc();
        if (ids.isEmpty()) return "EMP001";

        String lastId = ids.get(0);
        // Extract numeric part safely using regex
        String numericPart = lastId.replaceAll("[^0-9]", "");
        int number = 1;
        if (!numericPart.isEmpty()) {
            number = Integer.parseInt(numericPart) + 1;
        }
        return String.format("EMP%03d", number);
    }

    // Get all employees
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class))
                .toList();
    }

    // Get employee by ID
    public EmployeeDTO getEmployeeById(String employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    // Add new employee
    public EmployeeDTO addNewEmployee(Employee employee) {
        Optional<Employee> existing = employeeRepository.findByNic(employee.getNic());
        if (existing.isPresent()) {
            throw new RuntimeException("Employee with NIC " + employee.getNic() + " already exists!");
        }

        employee.setEmployeeId(generateEmployeeId()); // assign EMP ID
        Employee saved = employeeRepository.save(employee);
        return modelMapper.map(saved, EmployeeDTO.class);
    }

    // Update employee
    public EmployeeDTO updateEmployee(String id, Employee updatedDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

        employee.setName(updatedDetails.getName());
        employee.setEmail(updatedDetails.getEmail());
        employee.setNic(updatedDetails.getNic());
        employee.setGender(updatedDetails.getGender());
        employee.setPhone(updatedDetails.getPhone());
        employee.setRole(updatedDetails.getRole());
        employee.setSalary(updatedDetails.getSalary());
        employee.setHiredDate(updatedDetails.getHiredDate());
        employee.setResignedDate(updatedDetails.getResignedDate());
        employee.setDepartmentId(updatedDetails.getDepartmentId());

        Employee updated = employeeRepository.save(employee);
        return modelMapper.map(updated, EmployeeDTO.class);
    }

    // Delete employee
    public void deleteEmployee(String id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }

    // Get employees by department
    public List<EmployeeDTO> getEmployeesByDepartment(String departmentId) {
        List<Employee> employees = employeeRepository.findByDepartmentId(departmentId);
        return employees.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class))
                .toList();
    }
}
