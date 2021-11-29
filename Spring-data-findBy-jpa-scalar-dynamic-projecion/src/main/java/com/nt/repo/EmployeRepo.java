package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee;
import com.nt.view.View;

public interface EmployeRepo extends JpaRepository<Employee, Integer> {
	
	public <T extends View> List<T> findByEid(int eno,Class<T> clazz);
  
	

}
