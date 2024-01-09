package com.greatlearning.employee.service;

import java.util.List;

import com.greatlearning.employee.model.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int empId);

	public void saveEmployee(Employee theEmp);

	public void deleteById(int empId);
}
