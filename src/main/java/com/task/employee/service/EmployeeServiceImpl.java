package com.task.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.employee.customExceptions.EmptyInputException;
import com.task.employee.customExceptions.NoEmployeeFoundException;
import com.task.employee.dto.empDto;
import com.task.employee.entity.Employee;
import com.task.employee.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

//Service Layer

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	// method to fetch details of an existing employee, it takes id as a parameter
	// and returns the employee dto.
	public empDto getEmployeeById(Integer id) {
		if (id == null) {
			throw new EmptyInputException("the input body is null.");
		}
		if (empRepo.existsById(id)) {
			Optional<Employee> optionalObject = empRepo.findById(id);
			log.info("finding employee with id : {}", id);
			return optionalObject.isEmpty() ? null : empToDto(optionalObject.get());
		} else {
			throw new NoEmployeeFoundException("No such employee found.");
		}
	}

	// method to add a new employee which takes employee Dto as a parameter from
	// controller layer and returns the saved employee.
	public empDto addEmployee(empDto empDto) {
		if (empDto == null) {
			throw new EmptyInputException("the input body is null.");
		}
		log.info("saving employee details.");
		Employee temp = empRepo.save(dtoToEmployee(empDto));
		return empToDto(temp);
	}

	// method to update an existing employee, which takes an employee dto as a
	// parameter and returns the dto of update employee.
	public empDto updateEmployee(empDto empDto) {
		if (empDto == null) {
			throw new EmptyInputException("the input body is null.");
		}
		if (empRepo.existsById(empDto.getEmpId())) {
			Employee target = new Employee();
			BeanUtils.copyProperties(empDto, target);
			log.info("updating employee details.");
			Employee temp = empRepo.save(target);
			return empToDto(temp);
		} else {
			throw new NoEmployeeFoundException("No such employee found.");
		}
	}

	// method to delete an existing employee, by taking id as a parameter and
	// returns a string message.
	public String deleteEmployeeById(Integer id) {
		if (id == null) {
			throw new EmptyInputException("the input body is null.");
		}
		if (empRepo.existsById(id)) {
			empRepo.deleteById(id);
			return "The employee with id : " + id + "has been deleted.";
		} else {
			return "The employee with id : " + id + "was not found.";
		}
	}

	// method to which takes employee as a parameter and converts it into employee
	// dto
	public empDto empToDto(Employee emp) {
		empDto empDto = new empDto();
		BeanUtils.copyProperties(emp, empDto);
		return empDto;
	}

	// method to which takes employee dto parameter and converts it into employee
	public Employee dtoToEmployee(empDto empDto) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(empDto, emp);
		return emp;
	}

}
