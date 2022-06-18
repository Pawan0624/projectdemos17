package com.example.employee.crud.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.employee.crud.model.Employee;
import com.example.employee.crud.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/find/empid/{empid}")
	public ResponseEntity<Optional<Employee>> findEmployee(@PathVariable("empid") int empid) {

		return new ResponseEntity<>(service.findEmployee(empid), HttpStatus.CREATED);
		
	}

	@GetMapping("/find/{dept}")
	public ResponseEntity<List<Employee>> findAllEmployeesByDept(@PathVariable("dept") String dept) {

		List<Employee> emps = service.getEmployeesByDept(dept);

		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);

	}

	@GetMapping("/find/{dept}/{desg}")
	public ResponseEntity<List<Employee>> findAllEmployeesByDeptandDesg(@PathVariable("dept") String dept,
			@PathVariable("desg") String desg) {

		List<Employee> emps = service.getEmployeesByDeptAndDesg(dept, desg);

		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);

	}

	@GetMapping("/showAll")
	public ResponseEntity<List<Employee>> showAllEmployees() {

		List<Employee> emps = service.getAllEmployees();

		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);

	}

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{empid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("empid") int empid) {

		return new ResponseEntity<>(service.deleteEmployee(empid), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmpoyee(@RequestBody Employee employee) {
		return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.CREATED);
	}

}
