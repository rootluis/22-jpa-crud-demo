package com.mejia.springboot.cruddemo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.mejia.springboot.cruddemo.dao.EmployeeDAO;
import com.mejia.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> finAll() {

		// get the current hiberntae session
		Session currentSession = entityManager.unwrap(Session.class);

		// create the query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> listResult = theQuery.getResultList();

		// return the result

		return listResult;
	}

	@Override
	public Employee findEmployee(int idEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);		
		Employee theEmployee = currentSession.get(Employee.class, idEmployee);		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void delete(int idEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:idEmployeeDelete");
		theQuery.setParameter("idEmployeeDelete", idEmployee);
		theQuery.executeUpdate();
		
	}

}
