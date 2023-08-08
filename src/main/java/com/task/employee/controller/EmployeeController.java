package com.task.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.employee.dto.empDto;
import com.task.employee.service.EmployeeServiceImpl;

//Controller layer

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	// GetMapping method which accepts employee id as a parameter and calls
	// getEmployee method of service layer which in turn, returns an employee DTO.
	@GetMapping("/get/{id}")
	public empDto getEmployee(@PathVariable Integer id) {
		return employeeServiceImpl.getEmployeeById(id);
	}

	// PostMapping method which accepts employee Dto as a parameter and calls
	// addEmployee method of service layer which in turn, returns an employee DTO.
	@PostMapping("/add")
	public empDto postEmployee(@RequestBody empDto empDto) {
		return employeeServiceImpl.addEmployee(empDto);
	}

	// PutMapping method which accepts employee Dto as a parameter and calls
	// updateEmployee method of service layer which in turn, returns an employee
	// DTO.
	@PutMapping("/put")
	public empDto putEmployee(@RequestBody empDto empDto) {
		return employeeServiceImpl.updateEmployee(empDto);
	}

	// DeleteMapping method which accepts employee id as a parameter and calls
	// deleteEmployee method of service layer which in turn, returns an a string
	// message.
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		return employeeServiceImpl.deleteEmployeeById(id);
	}

}
