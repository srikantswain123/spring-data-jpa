package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.EmployeeDto;

public interface IEmployeService {
	public List<EmployeeDto> findAllObjectBySort(String property,boolean asc);
	public List<EmployeeDto> findAllObjectBySort(boolean asc,String ...properties);
	public List<EmployeeDto> findAllObjectByPagination(int pageNO,int pageSize);
	
	public void getAllEmployeeDEtailsByAutoPaging(int pageSize);
	

}
