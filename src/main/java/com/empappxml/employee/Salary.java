package com.empappxml.employee;

public class Salary {
	
	private double grassPay;

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
		return "Salary [grassPay=" + grassPay + "]";
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