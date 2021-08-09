package com.empappxml.service;

import java.util.LinkedHashSet;
import java.util.Set;
import com.empappxml.employee.Employee;
import com.empappxml.exception.EmployeeNotFoundException;

public class EmployeeServiceImp implements EmployeeService {
	private static Set<Employee> employeeSet;

	{
		employeeSet = new LinkedHashSet<>();
	}

	public Employee findById(int id) throws EmployeeNotFoundException {
		return null;
	}

	public Set<Employee> findAll() {
		return employeeSet;
	}

	public void newEmployee(Employee employee) {
		try {			
			employeeSet.add(employee);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {		
	}

	public void deleteEmployee(Employee employee) throws EmployeeNotFoundException {
	}

}