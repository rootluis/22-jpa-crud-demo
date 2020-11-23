package com.mejia.springboot.cruddemo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mejia.springboot.cruddemo.dao.EmployeeDAO;
import com.mejia.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public List<Employee> finAll() {
		Query theQuery = entityManager.createQuery("from Employee");
		List<Employee> listResult = theQuery.getResultList();
		return listResult;
	}

	@Override
	public Employee findEmployee(int idEmployee) {
		Employee theEmployee = entityManager.find(Employee.class, idEmployee);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee tmpEmployee = entityManager.merge(theEmployee);
		theEmployee.setId(tmpEmployee.getId());

	}

	@Override
	public void delete(int idEmployee) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:emploIdDelete");
		theQuery.setParameter("emploIdDelete", idEmployee);
		theQuery.executeUpdate();

	}

}
