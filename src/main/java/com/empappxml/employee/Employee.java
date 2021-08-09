package com.empappxml.employee;

import com.empappxml.service.EmployeeServiceImp;
import java.util.Set;

public class Employee {
	private int id;
	private String name;
	private String email;
	private String corpId;
	private String band;
	private long phoneNumber;
	private Salary salary;
	private EmployeeServiceImp service;
	
	public Employee() {
		System.out.println("Printing the default constructor from Employee");
	}

	public Employee(int id, String name, String email, String corpId, String band, long phoneNumber, Salary salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.corpId = corpId;
		this.band = band;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public void createEmp(Employee emp) {
		service = new EmployeeServiceImp();
		service.newEmployee(emp);
	}
	
	public void findAllEmp() {
		service = new EmployeeServiceImp();
		System.out.println(service.findAll());
		
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", corpId=" + corpId + ", band=" + band
				+ ", phoneNumber=" + phoneNumber + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corpId == null) ? 0 : corpId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (corpId != null) {
			if(other.corpId != null)
				return false;
		} else if (!corpId.equals(other.corpId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		return true;
	}
}