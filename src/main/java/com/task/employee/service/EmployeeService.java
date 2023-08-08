package com.task.employee.service;

import java.util.List;

import com.task.employee.dto.empDto;
import com.task.employee.entity.Employee;

public interface EmployeeService {
	public empDto getEmployeeById(Integer id);

	public empDto addEmployee(empDto emp);

	public empDto updateEmployee(empDto emp);

	public String deleteEmployeeById(Integer id);

	public empDto empToDto(Employee emp);

	public Employee dtoToEmployee(empDto empDto);
}
