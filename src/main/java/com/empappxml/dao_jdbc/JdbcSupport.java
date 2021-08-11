package com.empappxml.dao_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
	private static final String empById = "SELECT * FROM employee_info emp LEFT JOIN salary sal ON sal.employee_info_id = emp.id Where emp.id=?";
	private static final String newSal = "Insert into salary (fixed_pay, employee_info_id, pf) VALUES (?,?,?)";
	
	private List<Employee> employeeSet;
	private Employee employee;
	
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

	@SuppressWarnings("deprecation")
	@Override
	public Employee findById(int id) {
		employee = getJdbcTemplate().queryForObject(empById, new Object[] { id }, new RowMapper<Employee>() {

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
		return employee;
	}
	//name, email, corp_id, designation_id, band, phone_number
	public void saveBatch(List<Employee> employees) {
		getJdbcTemplate().batchUpdate(newEmp, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int rowNum) throws SQLException {
				Employee emp = employees.get(rowNum);
				ps.setString(1, emp.getName());
				ps.setString(2, emp.getEmail());
				ps.setString(3, emp.getCorpId());
				ps.setInt(4, 1);
				ps.setString(5, emp.getBand());
				ps.setLong(6, emp.getPhoneNumber());
			}
			@Override
			public int getBatchSize() {
				return employees.size();
			}
		});
	}
	
	@Override
	public void save(Employee employee) {
		getJdbcTemplate().update(newEmp, new Object[] { employee.getName(), employee.getEmail(), employee.getCorpId(), 3, 
				employee.getBand(), employee.getPhoneNumber() });
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
	
	// query single row with BeanPropertyRowMapper (Employee.class)
	// To Execute this method both the Class properties and Column should match
	// This Method is deprecated and it is not recommended.
	public Employee findByEmpId2(int empId) {

		String sql = "SELECT * FROM employee_info WHERE id = ?";

		Employee emp = (Employee) getJdbcTemplate().queryForObject(sql, new Object[] { empId },
				new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}
	
	// query multiple rows with BeanPropertyRowMapper (Customer.class)
	public List<Employee> findAll2() {

		String sql = "SELECT * FROM employee_info";

		List<Employee> customers = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));

		return customers;
	}

	public String findCustomerNameById(int custId) {

		String sql = "SELECT email FROM employee_info WHERE id = ?";
		String name = (String) getJdbcTemplate().queryForObject(sql, new Object[] { custId }, String.class);
		return name;

	}
	
	public void saveUsingPre(Employee emp) {
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(newEmp);
				ps.setString(1, emp.getName());
				ps.setString(2, emp.getEmail());
				ps.setString(3, emp.getCorpId());
				ps.setInt(4, 2);
				ps.setString(5, emp.getBand());
				ps.setLong(6, emp.getPhoneNumber());
				return ps;
			}
		});
	}
	
	public void saveWithSalary(Employee emp, Salary sal) {
		KeyHolder holder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(newEmp, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, emp.getName());
				ps.setString(2, emp.getEmail());
				ps.setString(3, emp.getCorpId());
				ps.setInt(4, 2);
				ps.setString(5, emp.getBand());
				ps.setLong(6, emp.getPhoneNumber());
				return ps;
			}
		}, holder);

		int newUserId = holder.getKey().intValue();
		emp.setId(newUserId);
		if(emp.getId() > 0) {
			saveSalary(emp, sal);
		}
	}
	
	public void saveSalary(Employee emp, Salary sal) {
		getJdbcTemplate().update(newSal, new Object[] { sal.getGrassPay(), emp.getId(), sal.getPf() });
	}

}
