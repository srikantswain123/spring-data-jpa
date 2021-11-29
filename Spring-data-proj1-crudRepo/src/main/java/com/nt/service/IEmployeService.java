package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.EmployeeDto;

public interface IEmployeService {
	public int saveObject(EmployeeDto dto);
	public int updateObject(EmployeeDto dto);
	public int[] groupRegistration(List<EmployeeDto> dto);
	public long objectCounts();
	
	public String deleteObject(int id);
	public Optional<EmployeeDto> findObjectById(int id);
	public String deleteObjectByEntity(int id);
	public String removeObjectBYEntity(List<EmployeeDto> dto);
	public List<EmployeeDto> findAllObject();
	public List<EmployeeDto> findAllObjectById(List<Integer> id);
	

}
