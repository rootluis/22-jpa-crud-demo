package com.mejia.springboot.cruddemo.service;

import java.util.List;

import com.mejia.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> finAll();

	public Employee findEmployee(int theId);

	public void save(Employee theEmployee);

	public void delete(int theId);

}
