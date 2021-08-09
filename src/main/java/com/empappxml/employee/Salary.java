package com.empappxml.employee;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class Salary {
	
	private double grassPay;
	private double pf;

	public Salary() {
		System.out.println("Printing the default constructor from Salary");
	}

	public double getGrassPay() {
		return grassPay;
	}

	public void setGrassPay(double grassPay) {
		this.grassPay = grassPay;
	}

	@Override
	public String toString() {
		return "Salary [grassPay=" + convertSalary("###.##", grassPay) + ", " + pf + "]";
	}
	
	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}
	
	public static String convertSalary(String patten, double grassPay) {
		System.out.println(grassPay);
		DecimalFormat df = new DecimalFormat(patten);
		String op = df.format(grassPay);
		System.out.println(op);
		return op;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(grassPay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Salary other = (Salary) obj;
		if (Double.doubleToLongBits(grassPay) != Double.doubleToLongBits(other.grassPay))
			return false;
		return true;
	}
	
}