package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Customer;
import com.nt.dto.CustomerDto;
import com.nt.repo.ICustomerRepo;

@Service("custService")
public class CustomerServiceMgmtImpl implements IcustomerServiceMgmt {

	@Autowired
	private ICustomerRepo repo;

	@Override
	public List<CustomerDto> getAllCustomerDetails() {
		List<Customer> doc=repo.findAll();
		List<CustomerDto> listdto=new ArrayList();
		doc.forEach(row->{
			CustomerDto dto=new CustomerDto();
			BeanUtils.copyProperties(row, dto);
			listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public Optional<CustomerDto> getCustomerDetails(String id) {
		Optional<Customer> doc=repo.findById(id);
		Optional<CustomerDto> dto=null;
		if(doc.isPresent()) {
			dto=Optional.of(new CustomerDto());
			BeanUtils.copyProperties(doc.get(), dto.get());
			return dto;
			
		}
		return Optional.empty();
	}
	
	@Override
	public String deleteObjectById(String id) {
		try {
		repo.deleteById(id);
		return id+" Object deleted sucessfully";
		}catch(Exception e) {
			e.printStackTrace();
			return "Object id not found for delete Object";
		}
		
	}

}
