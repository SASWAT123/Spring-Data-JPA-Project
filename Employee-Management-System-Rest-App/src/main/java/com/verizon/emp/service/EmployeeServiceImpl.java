package com.verizon.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.emp.dao.EmployeeRepository;
import com.verizon.emp.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public boolean deleteEmployee(int emp_id) {
		boolean isDeleted = false;
		if(empRepo.existsById(emp_id)) {
			empRepo.deleteById(emp_id);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public Employee getEmployeeById(int emp_id) {
		Employee emp = null;
		
		Optional<Employee> optEmployee = empRepo.findById(emp_id);
		if(optEmployee.isPresent()) {
			emp = optEmployee.get();
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

}
