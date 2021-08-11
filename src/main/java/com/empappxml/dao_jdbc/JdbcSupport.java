package com.empappxml.dao_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.empappxml.employee.Employee;
import com.empappxml.employee.Salary;

public class JdbcSupport extends JdbcDaoSupport implements DaoJdbc {

	private static final String newEmp = "Insert into employee_info (name, email, corp_id, designation_id, band, phone_number) VALUES (?,?,?,?,?,?)";
	private static final String updEmp = "Update employee_info SET name=?, email=?, designation_id=?, band=?, phone_number=? WHERE corp_id=?";
	private static final String delEmp = "Delete from employee_info WHERE corp_id=?";
	private static final String empWithSalary = "SELECT * FROM employee_info emp LEFT JOIN salary sal ON sal.employee_info_id = emp.id";
	private static final String empMaxPaid = "SELECT * FROM employee_info emp LEFT JOIN salary sal ON sal.employee_info_id = emp.id order by sal.fixed_pay desc LIMIT 1";
	private static final String empMinPaid = "SELECT * FROM employee_info emp LEFT JOIN salary sal ON sal.employee_info_id = emp.id order by sal.fixed_pay asc LIMIT 1";
	private static final String totalSal = "SELECT fixed_pay FROM salary";
	private static final String allEmp = "Select * from employee_info";
	
	private List<Employee> employeeSet;
	
	@Override
	public List<Employee> findAll() {
		employeeSet = getJdbcTemplate().query(allEmp, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setCorpId(rs.getString("corp_id"));
				emp.setPhoneNumber(rs.getLong("phone_number"));
				emp.setBand(rs.getString("band"));
				return emp;
			}
			
		});
		return employeeSet;
	}

	@Override
	public List<Employee> allEmpInfo() {
		employeeSet = getJdbcTemplate().query(empWithSalary, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				Salary sal = new Salary();
				sal.setGrassPay(rs.getDouble("fixed_pay"));
				sal.setPf(2001.98);
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setCorpId(rs.getString("corp_id"));
				emp.setPhoneNumber(rs.getLong("phone_number"));
				emp.setBand(rs.getString("band"));
				emp.setSalary(sal);
				return emp;
			}
			
		});
		return employeeSet;
	}

	@Override
	public List<Employee> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int totalEmpCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
