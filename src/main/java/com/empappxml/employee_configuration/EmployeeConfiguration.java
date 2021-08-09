package com.empappxml.employee_configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.empappxml.employee.Employee;

public class EmployeeConfiguration {
	
	public static void main(String[] args) {		
		ClassPathXmlApplicationContext empConfig = new ClassPathXmlApplicationContext("Employee.xml");
		Employee emp = empConfig.getBean("emp_1", Employee.class);
		System.out.println(emp);
		empConfig.close();
	}
	
}