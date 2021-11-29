package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer_Point;

public interface EmployeRepo extends JpaRepository<Customer_Point, Integer> {
	

}
