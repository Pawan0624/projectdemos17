package com.example.employee.crud.service;

import java.util.List;
import java.util.Optional;

import com.example.employee.crud.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee saveEmployee(Employee employee);
	public String deleteEmployee(int empid);
	public List<Employee> getEmployeesByDept(String dept);
	public List<Employee> getEmployeesByDeptAndDesg(String dept, String desg);
	public Optional<Employee> findEmployee(int empid);
}
