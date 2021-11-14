package es.com.example.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import es.com.example.api.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	public EmployeeDAOJpaImpl(EntityManager manager) {
		entityManager = manager;
	}
	
	@Override
	public List<Employee> getEmployees() {
		
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> list = query.getResultList();
		
		return list;
		
	}

	@Override
	public Employee getEmployeID(int id) {


		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
		
	}

	@Override
	public void save(Employee employee) {

		Employee tempEmployee = entityManager.merge(employee);
		
		employee.setId(tempEmployee.getId());
		
	}

	@Override
	public void delete(int id) {
		
		Query query = entityManager.createQuery("delete from Employee where id=:idEmployee");

		query.setParameter("idEmployee", id);

		query.executeUpdate();

	}

}
