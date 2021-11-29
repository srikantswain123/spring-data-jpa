package com.nt.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee;
import com.nt.projection.ResultView;

public interface EmployeRepo extends JpaRepository<Employee, Integer> {
  
	public List<ResultView> findByEaddIn(Collection<String> cities);
	public List<ResultView> findByEnameStartingWith(String initiach);


}
