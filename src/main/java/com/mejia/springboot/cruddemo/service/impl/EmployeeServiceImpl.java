package com.mejia.springboot.cruddemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mejia.springboot.cruddemo.dao.EmployeeDAO;
import com.mejia.springboot.cruddemo.entity.Employee;
import com.mejia.springboot.cruddemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO theEmployeeDAO) {
		this.employeeDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> finAll() {		
		return employeeDAO.finAll();
	}

	@Override
	@Transactional
	public Employee findEmployee(int theId) {		
		return employeeDAO.findEmployee(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);

	}

	@Override
	@Transactional
	public void delete(int theId) {
		employeeDAO.delete(theId);

	}

}
