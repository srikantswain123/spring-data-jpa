package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.EmployeeDto;

public interface IEmployeService {
public EmployeeDto getEmployeData(int eno);
public List<EmployeeDto> fetchEmployeeByExampleData(EmployeeDto dto,boolean asc,String property);
public void removeEmployeeInBatch(List<EmployeeDto> listDto);
}
