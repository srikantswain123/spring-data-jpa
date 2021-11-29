package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.enttity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	
	//hql joins
	
	
	//@Query("select d.dno,d.dname,d.company,d.location,e.eid,e.ename,e.eadd from Department d  inner join d.emp e")
	//@Query("select d.dno,d.dname,d.company,d.location,e.eid,e.ename,e.eadd from Department d  left join d.emp e")
	//@Query("select d.dno,d.dname,d.company,d.location,e.eid,e.ename,e.eadd from Department d  right join d.emp e")
	@Query("select d.dno,d.dname,d.company,d.location,e.eid,e.ename,e.eadd from Department d  full join d.emp e")
	public List<Object[]> getJoinResultParentToChild();
	
 	

}
