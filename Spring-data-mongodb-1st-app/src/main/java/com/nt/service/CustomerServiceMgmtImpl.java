package com.nt.service;

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
	public String saveObject(CustomerDto dto) {
		//create documrnt Object
		Customer bo=new Customer();
		//copy each dto to bo
		BeanUtils.copyProperties(dto, bo);
		//insert object
		bo=repo.insert(bo);
		return "save object using cno:"+bo.getCno();
	}
	@Override
	public String updateObject(CustomerDto dto) {
		//create documrnt Object
				Customer bo=new Customer();
				//copy each dto to bo
				BeanUtils.copyProperties(dto, bo);
				//insert object
				bo=repo.save(bo);
				return "update object using cno:"+bo.getCno();
	}

}
