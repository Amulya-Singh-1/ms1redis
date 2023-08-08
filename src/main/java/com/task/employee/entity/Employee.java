package com.task.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;

	private String empName;
	private Integer empSalary;
	private String deptName;
}
