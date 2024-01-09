package com.greatlearning.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	@Override
	public List<Employee> findAll() {
		return empRepository.findAll();
	}

	@Override
	public Employee findById(int empId) {
		Optional<Employee> result = empRepository.findById(empId);
		Employee emp = null;
		if (result.isPresent()) {
			emp = result.get();
		} else {
			throw new RuntimeException("Employee is not present with given Id : " + empId);
		}
		return emp;
	}

	@Override
	public void saveEmployee(Employee theEmp) {
		empRepository.save(theEmp);

	}

	@Override
	public void deleteById(int empId) {
		empRepository.deleteById(empId);

	}

}
