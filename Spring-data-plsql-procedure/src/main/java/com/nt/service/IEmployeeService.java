package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeService {
	public List<EmployeeDTO> getEmpsBysalRange(float startsal,float endsal);
    public List<Object[]> getEMpsSepecificColumnValues(String addrs1,String addrs2);

}
