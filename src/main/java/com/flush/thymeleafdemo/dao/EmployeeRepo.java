package com.flush.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flush.thymeleafdemo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	public List<Employee> findAllByOrderByLastNameAsc();

}
