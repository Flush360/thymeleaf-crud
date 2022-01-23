package com.flush.thymeleafdemo.service;

import java.util.List;

import com.flush.thymeleafdemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findall();

	public Employee findById(int emplId);

	public void save(Employee empl);

	public void deleteById(int emplId);

}
