package com.employee.employee.service;

import org.springframework.stereotype.Service;
import com.employee.employee.entity.Employee;
import com.employee.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee postEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id).get();
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setEmail(employee.getEmail());
        employeeToUpdate.setPhone(employee.getPhone());
        employeeToUpdate.setDepartment(employee.getDepartment());
        return employeeRepository.save(employeeToUpdate);
    }
}
