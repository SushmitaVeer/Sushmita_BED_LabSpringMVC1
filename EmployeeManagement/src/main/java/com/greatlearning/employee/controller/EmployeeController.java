package com.greatlearning.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/list")
	public String findAllEmployee(Model model) {
		List<Employee> emp = empService.findAll();
		model.addAttribute("employees", emp);

		return "employee_list";
	}

	@GetMapping("/new")
	public String addNewEmployee(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employees", emp);
		return "employee_new";
	}

	@PostMapping("/saveEmployee")
	public String saveNewEmp(Model model, @ModelAttribute("employees") Employee emp) {
		empService.saveEmployee(emp);
		return "redirect:/employees/list";
	}

	@GetMapping("/edit/{id}")
	public String editEmployee(Model model, @PathVariable int id) {
		Employee emp = empService.findById(id);
		model.addAttribute("employees", emp);
		return "employee_edit";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(Model model, @PathVariable int id) {
		Employee emp = new Employee();
		model.addAttribute("employees", emp);
		empService.deleteById(id);
		return "redirect:/employees/list";

	}

}
