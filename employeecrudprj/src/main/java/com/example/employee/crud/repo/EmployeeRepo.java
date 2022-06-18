package com.example.employee.crud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employee.crud.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

	@Query("select e from Employee e where e.dept=?1")
	public List<Employee> findEmployeesByDept(String dept);
	
	
	@Query("select e from Employee e where e.dept=?1 and e.desg=?2")
	public List<Employee> findEmployeesByDeptAndDesg(String dept, String desg);
	
}
