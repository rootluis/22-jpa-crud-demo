package com.mejia.springboot.cruddemo.dao;

import java.util.List;

import com.mejia.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> finAll();
	
	public Employee findEmployee(int idEmployee);
	
	public void save(Employee theEmployee);
	
	public void delete(int idEmployee);

}
