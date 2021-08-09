package com.empappxml.employee_configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeConfiguration {
	
	public static void main(String[] args) {		
		ClassPathXmlApplicationContext empConfig = new ClassPathXmlApplicationContext("Employee.xml");
		
		empConfig.close();
	}
	
}