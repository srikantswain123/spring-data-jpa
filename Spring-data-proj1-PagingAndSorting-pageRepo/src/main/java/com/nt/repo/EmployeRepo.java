package com.nt.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Employee;

public interface EmployeRepo extends PagingAndSortingRepository<Employee, Integer> {

}
