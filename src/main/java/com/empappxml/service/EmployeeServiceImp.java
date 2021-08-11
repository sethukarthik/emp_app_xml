package com.empappxml.service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import com.empappxml.employee.Employee;
import com.empappxml.exception.EmployeeNotFoundException;

public class EmployeeServiceImp implements EmployeeService {
	private static Set<Employee> employeeSet;
	private static Employee employee;

	public EmployeeServiceImp() {
		employeeSet = new LinkedHashSet<>();
	}

	public Employee findById(int id) throws EmployeeNotFoundException {
		Iterator<Employee> emps = employeeSet.iterator();
		while (emps.hasNext()) {
			Employee emp = emps.next();
			if(emp.getId() == id){
				employee = emp;
			}
		}
		return employee;
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