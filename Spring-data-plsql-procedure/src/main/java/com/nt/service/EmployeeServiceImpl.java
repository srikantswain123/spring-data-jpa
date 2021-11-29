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
	/*CREATE OR REPLACE PROCEDURE P_GET_EMPS_SAL_RANGE 
(
  STARTSALARY IN NUMBER 
, ENDSALARY IN NUMBER 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
  OPEN DETAILS FOR
  SELECT EID,ENAME,ESAL,DESG,EADD FROM EMPLOYEE WHERE ESAL>=startsalary AND ESAL<=endsalary;
END P_GET_EMPS_SAL_RANGE;*/

	@Override
	public List<EmployeeDTO> getEmpsBysalRange(float startsal, float endsal) {
		//creare stored procedure query
		StoredProcedureQuery procedure=em.createStoredProcedureQuery("P_GET_EMPS_SAL_RANGE", Employee.class);
		//register parameter
		procedure.registerStoredProcedureParameter(1, Float.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(2, Float.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(3, Employee.class, ParameterMode.REF_CURSOR);
		//set parameter
		procedure.setParameter(1, startsal);
		procedure.setParameter(2, endsal);
		
		List<Employee> listEntity=procedure.getResultList();
		List<EmployeeDTO> listDto=new ArrayList();
		
		listEntity.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			//copy each property
			BeanUtils.copyProperties(entity, dto);
			listDto.add(dto);
		});
		
	
		
		return listDto;
	}
	
	
	
	/*CREATE OR REPLACE PROCEDURE P_GET_EMPS_DETAILS_BY_ADDRS 
	(
	  ADDRS1 IN VARCHAR2 
	, ADDRS2 IN VARCHAR2 
	, DETAILS OUT SYS_REFCURSOR 
	) AS 
	BEGIN
	 OPEN DETAILS FOR
	 SELECT EID,ENAME,ESAL FROM EMPLOYEE WHERE EADD IN(ADDRS1,ADDRS2);
	END P_GET_EMPS_DETAILS_BY_ADDRS;
	*/
	
	
	@Override
	public List<Object[]> getEMpsSepecificColumnValues(String addrs1, String addrs2) {
		
		//creare stored procedure query
				StoredProcedureQuery procedure=em.createStoredProcedureQuery("P_GET_EMPS_DETAILS_BY_ADDRS");
				//register parameter
				procedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				procedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
				procedure.registerStoredProcedureParameter(3, Object[].class, ParameterMode.REF_CURSOR);
				//set parameter
				procedure.setParameter(1,addrs1);
				procedure.setParameter(2, addrs2);
			
		
		return procedure.getResultList();
	}
}
