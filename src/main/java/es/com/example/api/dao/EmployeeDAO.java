package es.com.example.api.dao;

import java.util.List;

import es.com.example.api.entity.Employee;

public interface EmployeeDAO {
	
	// retornar la lista de todos los empleados
	List<Employee> getEmployees();
	
	Employee getEmployeID(int id);
	
	void save(Employee employee);
	
	void delete(int id);


}
