package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDto_Point;
import com.nt.entity.Customer_Point;
import com.nt.repo.EmployeRepo;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private EmployeRepo repo;

	@Override
	public int saveObject(CustomerDto_Point dto) {
//create Entity Object
		Customer_Point entity=new Customer_Point();
		//copy each property to dto to entity
		BeanUtils.copyProperties(dto, entity);
		//save Object
		return repo.save(entity).getCustId();
	}
	@Override
	public List<CustomerDto_Point> getAllCustomerDetails() {
		//get customer Data
		List<Customer_Point> listEntity=repo.findAll();
		//convert each entity to dto
		List<CustomerDto_Point> listDto=new ArrayList();
		listEntity.forEach(entity->{
		 CustomerDto_Point dto=new CustomerDto_Point();
		 BeanUtils.copyProperties(entity, dto);
		 listDto.add(dto);
		});

		return listDto;
	}

}
