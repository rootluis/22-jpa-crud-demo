package com.mejia.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mejia.springboot.cruddemo.entity.Employee;
import com.mejia.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	// quick and dirty: inject employee dao (use constructor injection)
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}

	// expose "/employees" and return list of employee
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.finAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findEmployee(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee ID not Found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmploye(@PathVariable int employeeId) {
		Employee tmpEmploye = employeeService.findEmployee(employeeId);
		if (tmpEmploye == null) {
			throw new RuntimeException("El empleado: " + employeeId + " no existe en la Base de Datos.");
		}
		employeeService.delete(employeeId);
		return "Se ha eliminado el empleado: " + employeeId + " de la Base de Datos...";
	}
	
	

}
