package com.example.employee.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.crud.model.Employee;
import com.example.employee.crud.repo.EmployeeRepo;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepo repo;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repo.save(employee);
	}

	@Override
	public String deleteEmployee(int empid) {
		// TODO Auto-generated method stub
		repo.deleteById(empid);
		return "Employee Deleted";
	}

	@Override
	public List<Employee> getEmployeesByDept(String dept) {
		// TODO Auto-generated method stub
		return repo.findEmployeesByDept(dept);
	}

	@Override
	public List<Employee> getEmployeesByDeptAndDesg(String dept, String desg) {
		// TODO Auto-generated method stub
		return repo.findEmployeesByDeptAndDesg(dept, desg);
	}

	@Override
	public Optional<Employee> findEmployee(int empid) {
		// TODO Auto-generated method stub
		return repo.findById(empid);
	}

}
