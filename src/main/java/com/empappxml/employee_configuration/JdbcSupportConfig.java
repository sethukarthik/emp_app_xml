package com.empappxml.employee_configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.empappxml.dao_jdbc.JdbcSupport;
import com.empappxml.employee.Employee;
import com.empappxml.employee.Salary;

public class JdbcSupportConfig {
	public static void main(String[] args) {
		try {			
			ClassPathXmlApplicationContext jdbcSupport = new ClassPathXmlApplicationContext("dao_jdbc.xml");
			JdbcSupport empInfo = jdbcSupport.getBean(JdbcSupport.class);
			System.err.println("<--- Employee Info without Salary --->");
			System.out.println(empInfo.findAll());
			System.err.println("<--- Employee Info With Salary --->");
			System.out.println(empInfo.allEmpInfo());
			System.err.println("<--- Get Employee Info With Salary By CorpId --->");
			System.out.println(empInfo.findById(1));
			System.err.println("<--- Insert Multiple New Employee Info--->");
			List<Employee> emps = new ArrayList<>();
			//name, email, corp_id, designation_id, band, phone_number
			Employee emp1 = new Employee("Kavi", "kavi@mail.com", "KV1207", "L1", 955668841l);
			Employee emp2 = new Employee("Nithya", "nithya@mail.com", "NY1207", "L2", 955668841l);
			Employee emp3 = new Employee("Anand", "anand@mail.com", "AD1207", "L3", 955668841l);
			emps.add(emp3);
			emps.add(emp2);
			emps.add(emp1);
//			empInfo.saveBatch(emps); //Uncomment to insert new emp
			System.err.println("<--- Insert Single New Employee Info --->");
			empInfo.save(new Employee("Srini", "srini@mail.com", "SR1207", "L3", 9556688414l));
			System.err.println("<--- Find Employee ID Using Bean Rowmapper --->");
			// query single row with BeanPropertyRowMapper (Employee.class)
			// To Execute this method both the Class properties and Column should match
			// This Method is deprecated and it is not recommended.
			// System.out.println(empInfo.findByEmpId2(3));
			List<Employee> empls = empInfo.findAll2();
			for (Employee employee : empls) {
				System.out.println(employee);
			}
			System.err.println("<--- ******* --->");
			//System.out.println(empInfo.findCustomerNameById(3));
			System.err.println("<--- ******* --->");
			Employee emp4 = new Employee("Muthu", "muthu@mail.com", "MK4207", "L1", 8456987452l);
			empInfo.saveUsingPre(emp4); //Uncomment to insert new emp
			System.err.println("<--- ******* --->");
			Employee emp5 = new Employee("Raji", "raji@mail.com", "RJ85515", "L4", 8456987452l);
			Salary sal = new Salary(5800.62d,5200.25d);
			empInfo.saveWithSalary(emp5, sal); //Uncomment to insert new emp
			System.err.println("<--- ******* --->");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
