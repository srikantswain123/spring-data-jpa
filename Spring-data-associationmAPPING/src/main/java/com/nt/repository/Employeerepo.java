package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.enttity.Employee;

public interface Employeerepo extends JpaRepository<Employee, Integer> {

}
