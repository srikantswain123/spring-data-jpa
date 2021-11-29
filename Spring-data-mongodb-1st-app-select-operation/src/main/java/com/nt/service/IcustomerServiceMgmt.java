package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.CustomerDto;

public interface IcustomerServiceMgmt {

	public List<CustomerDto> getAllCustomerDetails();
	public Optional<CustomerDto> getCustomerDetails(String id);
	public String deleteObjectById(String id);
}
