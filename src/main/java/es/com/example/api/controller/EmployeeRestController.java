package es.com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.com.example.api.dao.EmployeeDAO;
import es.com.example.api.entity.Employee;
import es.com.example.api.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	private EmployeeService service;
	
	@Autowired
	public EmployeeRestController(EmployeeService service) {
		this.service = service;
	}

	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		
		return service.getEmployees();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployees(@PathVariable int employeeId) {
		
		return service.getEmployeID(employeeId);
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		
		service.delete(employeeId);
		
		return "Employee delete is: " + employeeId;
	}
	
	
	@PostMapping("/employee")
	public Employee add(@RequestBody Employee employee) {
		
		employee.setId(0);
		service.save(employee);
		
		return employee;
	}
	
	@PutMapping("/employee")
	public Employee put(@RequestBody Employee employee) {

		service.save(employee);
		
		return employee;
		
	}
	

}
