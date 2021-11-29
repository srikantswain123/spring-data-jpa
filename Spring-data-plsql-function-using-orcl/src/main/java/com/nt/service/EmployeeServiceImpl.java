package com.nt.service;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EntityManager em;
	/*CREATE OR REPLACE FUNCTION FX_AUTHENTICATION 
(
  UNAMES IN VARCHAR2 
, PWDS IN VARCHAR2 
) RETURN VARCHAR2 AS 
CNT NUMBER(10);
RESULT VARCHAR2(25);
BEGIN
  SELECT COUNT(*) INTO CNT FROM USERINFO WHERE UNAME=UNAMES AND PWD=PWDS;
  IF(CNT<>0)THEN
  RESULT:='VALID CREDENTIAL';
  ELSE
  RESULT:='INVALID CREDENTIAL';
  END IF;
  RETURN RESULT;
END FX_AUTHENTICATION;*/
	
	@Override
	public String credential(String uname, String pwd) {
		Session ses=em.unwrap(Session.class);
		
		String result=ses.doReturningWork(con->{
			CallableStatement cs=con.prepareCall("{?=call FX_AUTHENTICATION(?,?)}");
			//register return parameter
			cs.registerOutParameter(1, Types.VARCHAR);
			//set parameter
			cs.setString(2, uname);
			cs.setString(3, pwd);
			//excute function
			cs.execute();
			return cs.getString(1);
		});
		return result;
	}//method
	
	
	
	
}//class
