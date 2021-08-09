package com.empappxml.service;

import java.util.Set;
import com.empappxml.employee.Employee;
import com.empappxml.exception.EmployeeNotFoundException;

public class EmployeeServiceImp implements EmployeeService {
	private static Set<Employee> employeeSet;

	public Employee findById(int id) throws EmployeeNotFoundException {
		return null;
	}

	public Set<Employee> findAll() {
		return null;
	}

	public void newEmployee(Employee employee) {
		employeeSet.add(employee);
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {		
	}

	public void deleteEmployee(Employee employee) throws EmployeeNotFoundException {
	}

}