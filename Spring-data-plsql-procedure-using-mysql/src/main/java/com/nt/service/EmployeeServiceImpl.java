package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EntityManager em;
	/*CREATE  PROCEDURE `p_get_emps_data`(in citi1 varchar(20),in city2 varchar(20))
BEGIN
select eid,ename,esal,desg,eadd from employee where eadd in(city1,city2);
END*/
@Override
public List<EmployeeDTO> getAllEmpsDetails(String... cities) {
	StoredProcedureQuery procedure=em.createStoredProcedureQuery("p_get_emps_data", Employee.class);
	//register all parameters
	procedure.registerStoredProcedureParameter(1,  String.class, ParameterMode.IN);
	procedure.registerStoredProcedureParameter(2,  String.class, ParameterMode.IN);
	//set parameters
	procedure.setParameter(1, cities[0]);
	procedure.setParameter(2, cities[1]);
	List<Employee> listEntity=procedure.getResultList();
    List<EmployeeDTO> listDto=new ArrayList();
    listEntity.forEach(entity->{
    	EmployeeDTO dto=new EmployeeDTO();
    	BeanUtils.copyProperties(entity, dto);
    	listDto.add(dto);
    });
	
	return listDto;
}
	
	
	
	
}//class
