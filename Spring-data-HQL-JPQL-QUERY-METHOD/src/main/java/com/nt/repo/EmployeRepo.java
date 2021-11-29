package com.nt.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Employee;

public interface EmployeRepo extends JpaRepository<Employee, Integer> {
	
	@Query("From Employee where eadd=:addrs")
	public List<Employee> getAllEmployeeDeatilsByAddrs(String addrs);
	
	@Query("From Employee where esal>=:start AND esal<=:end")
	public List<Employee> fetchAllEmployeBysal(@Param("start") float start,@Param("end")float end);
	//------------------specific multiple column values--------------------
	@Query("Select eid,ename from Employee where eadd in(:city1,:city2,:city3)")
	public List<Object[]> fectchEmpDetailsByCities(String city1,String city2,String city3);
  
	@Query("Select eid,ename from Employee where ename like :init%")
	public List<Object[]> fecthEpDetailsByNameIitChars(String init);
	
	//---------------retriving single column values
	@Query("select ename from Employee where eid between :start and :end")
	public List<String> findEmpNamesByEidRange(int start,int end);
	
	
	//retriving all column values with single row
	@Query("from Employee where eid=:eid")
	public Employee findAllEmployeeDetailsByEid(int eid);
	
	@Query("select eid,ename from Employee where eid=:eid")
	public Object  findEMployeePartialDetailsBYEid(int eid);
	
	@Query("select esal from Employee where eid=:eid")
	public float findEmployeeSalaryByEid(int eid);
	
	//Agregate function using hql
	@Query("SELECT COUNT(*) FROM Employee")
	public int getEmployeCounts();
	
	@Query("SELECT COUNT(*),MAX(esal),MIN(esal),AVG(esal) from Employee")	
	public Object getEmpsAgregateData();
	
	//noncselect operation using hql/jpql
	@Query("UPDATE Employee SET esal=esal+:bonus where esal<=:sal")
	@Modifying
	@Transactional
	public int updateEMpsBysal(float bonus,float sal);
	
	@Query("DELETE FROM Employee WHERE eadd IS NULL")
	@Modifying
	@Transactional
	public int deleteEmployeNullEadd();
	
	
	//nativesql using hql
	
	@Query(value="SELECT SYSDATE FROM DUAL",nativeQuery = true)
	public String getSysDate();
	
	//insert Query using native Hql
	@Query(value="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)",nativeQuery = true)
	@Modifying
	@Transactional
   public int insertEmployeeUsingNativeSQl(int eid,String desg,String ename,float esal,String eadd);	

}
