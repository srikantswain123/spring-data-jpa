package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.enttity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	
 	

}
