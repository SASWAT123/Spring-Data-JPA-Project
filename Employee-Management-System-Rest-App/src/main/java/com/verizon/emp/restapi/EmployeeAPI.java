package com.verizon.emp.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.emp.model.Employee;
import com.verizon.emp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeAPI {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(
				empService.getAllEmployees(),HttpStatus.OK
				);
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable ("id") int emp_id){
		ResponseEntity<Employee> resp = null;
		
		Employee e = empService.getEmployeeById(emp_id);
		if(e == null) {
			resp = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}else {
			resp = new ResponseEntity<Employee>(e, HttpStatus.OK);
		}
		
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		ResponseEntity<Employee> resp = null;
		Employee e = empService.addEmployee(employee);
		resp = new ResponseEntity<Employee>(e, HttpStatus.OK);
		
		return resp;
	}
	
	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		ResponseEntity<Employee> resp = null;
		Employee e = empService.updateEmployee(employee);
		resp = new ResponseEntity<Employee>(e, HttpStatus.OK);
		
		return resp;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable ("id") int emp_id){
		ResponseEntity<Employee> resp = null;
		
		if(empService.deleteEmployee(emp_id)) {
			resp = new ResponseEntity<Employee>(HttpStatus.OK);
		}else {
			resp = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		return resp;
	}
}
