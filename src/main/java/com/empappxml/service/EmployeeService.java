package com.empappxml.service;

import java.util.Set;
import com.empappxml.employee.Employee;
import com.empappxml.exception.EmployeeNotFoundException;

public interface EmployeeService{
	//Find employee by ID
	Employee findById(int id) throws EmployeeNotFoundException;
	
	//Get all the employees
	Set<Employee> findAll();
	
	//Insert new employee profile to the list
	void newEmployee(Employee employee);

	//Update exits employee profile in the list
	void updateEmployee(Employee employee)  throws EmployeeNotFoundException;
	
	//Remove employee from the list using id or corp id
	void deleteEmployee(Employee employee)  throws EmployeeNotFoundException;
}