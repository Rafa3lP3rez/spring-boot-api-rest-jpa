package es.com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.com.example.api.dao.EmployeeDAO;
import es.com.example.api.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employee;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employee) {
		this.employee = employee;
	}
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employee.getEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeID(int id) {
		// TODO Auto-generated method stub
		return employee.getEmployeID(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		
		this.employee.save(employee);

	}

	@Override
	@Transactional
	public void delete(int id) {
		
		this.employee.delete(id);

	}

	

}
