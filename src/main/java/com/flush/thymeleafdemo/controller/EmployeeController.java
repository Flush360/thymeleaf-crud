package com.flush.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flush.thymeleafdemo.entity.Employee;
import com.flush.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService emplService;

	public EmployeeController(EmployeeService theEmplService) {
		emplService = theEmplService;
	}

	@GetMapping("/list")
	public String load(Model theModel) {
		List<Employee> empls = emplService.findall();
		theModel.addAttribute("empls", empls);

		return "/employees/list-employees";
	}

	@GetMapping("/add")
	public String addForm(Model theModel) {
		Employee empl = new Employee();
		theModel.addAttribute("empl", empl);

		return "employees/employee-form";

	}

	@GetMapping("/update")
	public String updateEmpl(@RequestParam("emplId") int id, Model theModel) {
		Employee empl = emplService.findById(id);
		theModel.addAttribute("empl", empl);
		return "employees/employee-form";

	}

	@GetMapping("/delete")
	public String deleteEmpl(@RequestParam("emplId") int id) {
		emplService.deleteById(id);
		return "redirect:/employees/list";
	}

	@PostMapping("/save")
	public String saveEmpl(@ModelAttribute("empl") Employee empl) {

		emplService.save(empl);
		// use redirect to prevent duplicate
		return "redirect:/employees/list";
	}

}
