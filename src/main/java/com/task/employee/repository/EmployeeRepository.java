package com.task.employee.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.task.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	public static final String HashKey="Product";
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	public Employee save(Employee emp) {
		redisTemplate.opsForHash().put(HashKey, emp.getEmpId(), emp);
	}

}
