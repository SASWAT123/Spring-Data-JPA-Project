package com.verizon.emp.service;

import java.util.List;

import com.verizon.emp.model.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	boolean deleteEmployee(int emp_id);
	Employee getEmployeeById(int emp_id);
	List<Employee> getAllEmployees();

}
