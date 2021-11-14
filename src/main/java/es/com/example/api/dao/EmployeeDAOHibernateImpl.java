package es.com.example.api.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.com.example.api.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entityManager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getEmployees() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

		List<Employee> list = query.getResultList();

		return list;
	}

	@Override
	public Employee getEmployeID(int id) {

		Session session = entityManager.unwrap(Session.class);

		Employee tempEmployee = session.get(Employee.class, id);

		return tempEmployee;
	}

	@Override
	public void save(Employee employee) {

		Session session = entityManager.unwrap(Session.class);

		session.saveOrUpdate(employee);

	}

	@Override
	public void delete(int id) {

		Session session = entityManager.unwrap(Session.class);

		Query query = session.createQuery("delete from Employee where id=:idEmployee");

		query.setParameter("idEmployee", id);

		query.executeUpdate();

	}

	

}
