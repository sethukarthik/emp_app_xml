package com.empappxml.dao_jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.JdbcTemplate;
import com.empappxml.employee.Employee;

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
		return null;
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
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employee_info", Integer.class);
	}
}	
