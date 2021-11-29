package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.enttity.Employee;

public interface Employeerepo extends JpaRepository<Employee, Integer> {
	
	//@Query("select e.eid,e.ename,e.eadd,d.dno,d.dname,d.location,d.company from Employee e inner join e.dept d")
	//@Query("select e.eid,e.ename,e.eadd,d.dno,d.dname,d.location,d.company from Employee e left join e.dept d")
	//@Query("select e.eid,e.ename,e.eadd,d.dno,d.dname,d.location,d.company from Employee e right join e.dept d")
	@Query("select e.eid,e.ename,e.eadd,d.dno,d.dname,d.location,d.company from Employee e full join e.dept d")
	public List<Object[]> getJoinResultChildToParent();

}
