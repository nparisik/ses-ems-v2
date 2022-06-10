package org.securitases.union.sesems.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.securitases.union.sesems.domain.Employee;
import org.securitases.union.sesems.repository.EmployeeRepository;

@Service // Class for business logic and functionality
public class EmployeeService {
	
	@Autowired // Handling of Bean auto-generated by Spring
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() { // List all employees
		return employeeRepository.findAll();
	}
	
	public void saveEmployee(Employee emp) { // Write new employee to DB
		employeeRepository.save(emp);
	}
	
	public Optional<Employee> getEmployeeById(Long id) { // List employee, searching based on unique ID
		
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp == null) {
			throw new RuntimeException("Error: employee not found.");
		}
		return emp;
	}
	
	public String deleteEmployeeById(Long id) {
		
		Optional<Employee> emp = employeeRepository.findById(id);
		Employee emp_info = emp.get();
		if (emp_info == null) {
			throw new RuntimeException("Error: employee not found.");
		}
		
		employeeRepository.deleteById(id);
		
		return "Deleted: " + emp_info.getFirstName() + " " + emp_info.getLastName();
	}
}
