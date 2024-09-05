package com.lec.quiz;
// name, annualSalary, computePay(abstract),computeIncentive(final)
public class SalaryEmployee extends Employee{
	private int annualSalary;
	public SalaryEmployee(String name, int annualSalary) {
		super(name);
		this.annualSalary = annualSalary;
	}
	@Override
	public int computePay() {
		// TODO Auto-generated method stub
		return annualSalary / 14 ;
	}
}
