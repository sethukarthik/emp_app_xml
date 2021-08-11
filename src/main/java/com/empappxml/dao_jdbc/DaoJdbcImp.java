package com.empappxml.dao_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.empappxml.employee.Employee;
import com.empappxml.employee.Salary;

public class DaoJdbcImp implements DaoJdbc{
	
	private JdbcTemplate jdbcTemplate;
	private List<Employee> employeeSet;

	public DaoJdbcImp() {
	}

	public JdbcTemplate getJdbcTemp() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemp) {
		this.jdbcTemplate = jdbcTemp;
	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("SELECT * FROM employee_info", new ResultSetExtractor<List<Employee>>(){

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				employeeSet = new ArrayList<>();
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getInt("id"));
					emp.setName(rs.getString("name"));
					emp.setEmail(rs.getString("email"));
					emp.setCorpId(rs.getString("corp_id"));
					emp.setPhoneNumber(rs.getLong("phone_number"));
					emp.setBand(rs.getString("band"));
					employeeSet.add(emp);
				}
				return employeeSet;
			}  
		});
	}
	
	@Override
	public List<Employee> allEmpInfo() {
		return jdbcTemplate.query("SELECT * FROM employee_info e left join salary s ON s.employee_info_id = e.id", new RowMapper<Employee>() {
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
	}
	
	@Override
	public Employee findById(int id) {
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
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employee_info", Integer.class);
	}
}	
