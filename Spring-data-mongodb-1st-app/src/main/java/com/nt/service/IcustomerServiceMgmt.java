package com.nt.service;

import com.nt.dto.CustomerDto;

public interface IcustomerServiceMgmt {
	public String saveObject(CustomerDto dto);
	public String updateObject(CustomerDto dto);

}
