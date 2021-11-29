package com.nt.service;

import java.util.List;

import com.nt.dto.CustomerDto_Point;

public interface ICustomerService {
	
	public int saveObject(CustomerDto_Point dto);
	public List<CustomerDto_Point> getAllCustomerDetails();

}
