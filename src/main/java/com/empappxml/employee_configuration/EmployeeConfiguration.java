package com.empappxml.employee_configuration;

import java.util.Iterator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.empappxml.employee.Employee;
import com.empappxml.employee.Salary;
import com.empappxml.exception.EmployeeNotFoundException;
import com.empappxml.service.EmployeeServiceImp;

public class EmployeeConfiguration {
	
	public static void main(String[] args) {		
		ClassPathXmlApplicationContext empConfig = new ClassPathXmlApplicationContext("Employee.xml");
		Employee emp_sethu = empConfig.getBean("emp_1", Employee.class);
		Employee emp_nithya = empConfig.getBean("emp_2", Employee.class);
		System.out.println("<------ Begin of Printing Employee -------->");
		System.out.println(emp_sethu);
		System.out.println(emp_nithya);
		System.out.println("<------ End of Printing Employee -------->");
		//Get Service bean
		EmployeeServiceImp serviceImp = empConfig.getBean("service", EmployeeServiceImp.class);
		serviceImp.newEmployee(emp_sethu);
		serviceImp.newEmployee(emp_nithya);
		//Find all employee and Iterate
		System.out.println("<------- Begin of set employee ------>");
		Employee emp_3 = empConfig.getBean("emp_3", Employee.class);
		Salary sal_4 = empConfig.getBean("setSalaryConfig", Salary.class);
		emp_3.setId(3);
		emp_3.setName("Nagesh");
		emp_3.setEmail("nagesh@gmail.com");
		emp_3.setCorpId("NAGS123");
		emp_3.setBand("B3");
		emp_3.setPhoneNumber(9566841128l);
		sal_4.setGrassPay(86012.25);
		sal_4.setPf(4502.14);
		emp_3.setSalary(sal_4);
		serviceImp.newEmployee(emp_3);
		System.out.println("<------- End of set employee -------->");
		
		System.out.println("<------- Begin of Find All ------>");
		Iterator<Employee> empIt = serviceImp.findAll().iterator();
		while (empIt.hasNext()) {
			Employee employee = (Employee) empIt.next();
			System.out.println(employee);
		}
		System.out.println("<------- End of Find All -------->");
		
		System.out.println("<------- Begin of Find By Id ------>");
		try {
			Employee empById = serviceImp.findById(3);
			System.out.println(empById);
		} catch (EmployeeNotFoundException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("<------- End of Find By Id -------->");
		
		empConfig.close();
	}
	
}