package com.flush.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flush.thymeleafdemo.dao.EmployeeRepo;
import com.flush.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImplJpa implements EmployeeService {

	private EmployeeRepo emplRepo;

	@Autowired
	public EmployeeServiceImplJpa(EmployeeRepo theEmplRepo) {
		emplRepo = theEmplRepo;
	}

	@Override

	public List<Employee> findall() {
		return emplRepo.findAllByOrderByLastNameAsc();
	}

	@Override

	public Employee findById(int emplId) {
		Optional<Employee> result = emplRepo.findById(emplId);
		Employee empl = null;
		if (result.isPresent()) {
			empl = result.get();
		} else {
			throw new RuntimeException("Employee with id: " + emplId + " not found");
		}
		return empl;
	}

	@Override

	public void save(Employee empl) {
		emplRepo.save(empl);
	}

	@Override

	public void deleteById(int emplId) {
		emplRepo.deleteById(emplId);

	}

}
