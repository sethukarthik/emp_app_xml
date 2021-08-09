package com.empappxml.exception;

public class EmployeeNotFoundException extends Exception {
	
	public EmployeeNotFoundException(Object message) {
		System.err.println(message);
	}
	
}
