package com.empappxml.employee_configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.empappxml.dao_jdbc.JdbcSupport;

public class JdbcSupportConfig {
	public static void main(String[] args) {
		try {			
			ClassPathXmlApplicationContext jdbcSupport = new ClassPathXmlApplicationContext("dao_jdbc.xml");
			JdbcSupport empInfo = jdbcSupport.getBean(JdbcSupport.class);
			System.err.println("<--- Employee Info without Salary --->");
			System.out.println(empInfo.findAll());
			System.err.println("<--- Employee Info With Salary --->");
			System.out.println(empInfo.allEmpInfo());
			System.err.println("<--- ******* --->");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
