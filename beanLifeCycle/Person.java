package beanLifeCycle;

import javax.annotation.PostConstruct;

public class Person {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	private String name;
	private int salary;
	
	@PostConstruct
	public void postConstruction() {
		System.out.println("Hey inside postconstruct annotation!!!");
	}
}
