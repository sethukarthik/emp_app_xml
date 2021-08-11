package com.empappxml.dao_jdbc;

import java.util.List;

import com.empappxml.employee.Employee;

public interface DaoJdbc {
	//find all the emp from emp_info
	List<Employee> findAll();
	
	//find employee using corp id
	List<Employee> findById(int id);
	
	//create a new employee
	void save(Employee employee);
	
	//Update employee profile
	void update(Employee employee);
	
	//delete a employee
	void delete(int id);
	
	int totalEmpCount();
}
