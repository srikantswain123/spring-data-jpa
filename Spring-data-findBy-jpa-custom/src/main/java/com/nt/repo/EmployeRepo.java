package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee;

public interface EmployeRepo extends JpaRepository<Employee, Integer> {

	public List<Employee> findByEid(int eiid);
	public List<Employee> findByename(String name);
	//select eno,ename,esal,desg,eadd from Employee where esal<?
	public List<Employee> findByesalLessThan(float sal);
	//select eno,ename,esal,desg,eadd from Employee where esal>=?
	public List<Employee> findByesalGreaterThanEqual(float sal);
	//select eno,ename,esal,desg,eadd from Employee where ename like '%r';
	public List<Employee> findByenameLike(String ename);
	//select eno,ename,esal,desg,eadd from Employee where ename like '%r';
    public List<Employee> findByenameStartingWith(String chars);
    //select eno,ename,esal,desg,eadd from Employee where ename like '%r%';
    public List<Employee> findByenameContaining(String chars);  
    //select eno,ename,sal,desg,eadd from Employee where eadd in('hyd','mumbai','delhi');
    public List<Employee> findByeaddIn(List<String> address);
  //select eno,ename,sal,desg,eadd from Employee where eadd not in('hyd','mumbai','delhi');
    public List<Employee> findByeaddNotIn(List<String> address);
    //select eno,ename,sal,desg,eadd from Employee where eadd is null;
    public List<Employee> findByeaddIsNull();
    //select eno,ename,sal,desg,eadd from Employee where eadd is not null;
    public List<Employee> findByeaddIsNotNull();
    //select eno,ename,sal,eadd from employee where eadd=upper(?);
    public List<Employee> findByeaddIgnoreCase(String addrs);
    //select eno,ename,sal,desg,eadd form employee where eadd=? order by eno asc;
    public List<Employee> findByEaddOrderByEidAsc(String addrs);
    //select eno,ename,sal,desg,eadd from employee where ename=? and eadd=?
    public List<Employee>  findByEnameAndEadd(String name,String addrs);
    //select eno,ename,sal,desg,eadd from employee where esal=? or eadd=?;
    public List<Employee> findByEsalOrEadd(float sal,String addrs);
    //select eno,ename,esal,desg,eadd from Employee where esal between ? AND ?;
    public List<Employee> findByEsalBetween(float esal1,float esal2);
    //select eno,ename,esal,desg,eadd from Employee where (eno>=? and ename like '?%') OR (esal between ? and ?)
    public List<Employee> findByEidAndEnameEndingWithOrEsalBetween(int eno,String ename,float startSal,float endSal);
    //select eno,ename,esal,desg,eadd from Employee where ename in(?,?,?) or eadd in(?,?,?);
    public List<Employee> findByEnameInOrEaddIn(List<String> ename,List<String> addrs);
	
	


}
