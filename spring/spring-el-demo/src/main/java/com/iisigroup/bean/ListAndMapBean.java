package com.iisigroup.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ListAndMapBean {
	@Value("#{workersHolder.salaryByWorkers['John']}") // Will inject 35000
	private int johnSalary;

	@Value("#{workersHolder.salaryByWorkers['George']}") // Will inject 14000
	private int georgeSalary;

	@Value("#{workersHolder.salaryByWorkers['Susie']}") // Will inject 47000
	private int susieSalary;

	@Value("#{workersHolder.workers[0]}") // Will inject John
	private String firstWorker;

	@Value("#{workersHolder.workers[3]}") // Will inject George
	private String lastWorker;

	@Value("#{workersHolder.workers.size()}") // Will inject 4
	private int numberOfWorkers;

	public int getJohnSalary() {
		return johnSalary;
	}

	public void setJohnSalary(int johnSalary) {
		this.johnSalary = johnSalary;
	}

	public int getGeorgeSalary() {
		return georgeSalary;
	}

	public void setGeorgeSalary(int georgeSalary) {
		this.georgeSalary = georgeSalary;
	}

	public int getSusieSalary() {
		return susieSalary;
	}

	public void setSusieSalary(int susieSalary) {
		this.susieSalary = susieSalary;
	}

	public String getFirstWorker() {
		return firstWorker;
	}

	public void setFirstWorker(String firstWorker) {
		this.firstWorker = firstWorker;
	}

	public String getLastWorker() {
		return lastWorker;
	}

	public void setLastWorker(String lastWorker) {
		this.lastWorker = lastWorker;
	}

	public int getNumberOfWorkers() {
		return numberOfWorkers;
	}

	public void setNumberOfWorkers(int numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}

}
