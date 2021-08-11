package com.empappxml.employee_configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.empappxml.dao_jdbc.DaoJdbcImp;

public class DaoConfiguration {
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext daoBean = new ClassPathXmlApplicationContext("dao_jdbc.xml");
			DaoJdbcImp daoC = daoBean.getBean(DaoJdbcImp.class);
			System.out.println(daoC.totalEmpCount());
			daoBean.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
