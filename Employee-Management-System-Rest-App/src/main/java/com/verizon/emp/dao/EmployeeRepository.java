package com.verizon.emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verizon.emp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
