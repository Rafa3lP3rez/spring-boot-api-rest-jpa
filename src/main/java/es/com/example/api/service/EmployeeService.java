package es.com.example.api.service;

import java.util.List;

import es.com.example.api.entity.Employee;

public interface EmployeeService {

	// retornar la lista de todos los empleados
		List<Employee> getEmployees();
		
		Employee getEmployeID(int id);
		
		void save(Employee employee);
		
		void delete(int id);

}
