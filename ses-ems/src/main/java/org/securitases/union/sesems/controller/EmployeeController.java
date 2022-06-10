package org.securitases.union.sesems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.securitases.union.sesems.domain.Employee;
import org.securitases.union.sesems.service.EmployeeService;

@Controller // Handles HTTP requests and mapping
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping("/") // Method executed upon user GET request to "http://localhost:8080/"
	public String loginPage(Model model) {
		model.addAttribute("listEmployees", empService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		
		Employee employee = new Employee(); // Used for server-side HTML rendering with Thymeleaf
		model.addAttribute("employee", employee);
		return "new_employee"; // shows new_employee.html template
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// After saving new employee to DB, redirect to home page
		empService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showUpdateForm(@PathVariable Long id, Model model) {
		
		Optional<Employee> employee = empService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable Long id, Model model) {
		empService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
