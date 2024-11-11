package com.employee.employee.service;

import org.springframework.stereotype.Service;
import com.employee.employee.entity.Employee;
import com.employee.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

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
        Optional<Employee> employeeToUpdate = employeeRepository.findById(id);
        if (employeeToUpdate.isPresent()){
            Employee existingEmployee = employeeToUpdate.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhone(employee.getPhone());
            existingEmployee.setDepartment(employee.getDepartment());
        return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
