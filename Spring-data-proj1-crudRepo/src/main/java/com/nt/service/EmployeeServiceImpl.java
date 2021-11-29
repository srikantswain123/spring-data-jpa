package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDto;
import com.nt.entity.Employee;
import com.nt.repo.EmployeRepo;
@Service("empService")
public class EmployeeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepo repo;
	@Override
	public int saveObject(EmployeeDto dto) {
		Employee emp=new Employee();
		BeanUtils.copyProperties(dto,emp);
		return repo.save(emp).getEid();
	}
	
	@Override
	public int updateObject(EmployeeDto dto) {
		Employee emp=new Employee();
		BeanUtils.copyProperties(dto,emp);
		return repo.save(emp).getEid();
	}
	
	@Override
	public int[] groupRegistration(List<EmployeeDto> dto) {
		List<Employee> listEmp=new ArrayList();
		dto.forEach(row->{
			Employee emp=new Employee();
			BeanUtils.copyProperties(row, emp);
			listEmp.add(emp);
		});
	  //save all object
		
	List<Employee> listEmp1= (List<Employee>) repo.saveAll(listEmp);
	int ids[]=new int[listEmp1.size()];
	   for(int i=0;i<listEmp1.size();++i) {
		  ids[i]=listEmp1.get(i).getEid();
	   }
		return ids;
	}
	@Override
	public long objectCounts() {
		return repo.count();
	}
	
	@Override
	public String deleteObject(int id) {
		boolean flag=false;
		if(repo.existsById(id)) {
			repo.deleteById(id);
		flag=true;
		}
		
		return flag?"Object deleted sucessfully":"object not available for deleted";
	}
	
	@Override
	public Optional<EmployeeDto> findObjectById(int id) {
		Optional<Employee> opt=repo.findById(id);
		
		Optional<EmployeeDto> optional=Optional.empty();
		if(opt.isPresent()) {
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(opt.get(), dto);
			optional=Optional.of(dto);
		}
		
		return optional;
	}
	
	@Override
	public String deleteObjectByEntity(int id) {
		Optional<Employee> opt=repo.findById(id);
		if(opt.isPresent()) {
			repo.delete(opt.get());
			return "Object deleted";
		}
		return "Object not available for deleted";
	}//method

	
	
	@Override
	public String removeObjectBYEntity(List<EmployeeDto> dto) {
		List<Employee> list=new ArrayList();
		dto.forEach(dtos->{
			Employee entity=new Employee();
			BeanUtils.copyProperties(dtos, entity);
			list.add(entity);
		});
		    repo.deleteAll(list);
		return "Objects are deleted";
	}
	
	@Override
	public List<EmployeeDto> findAllObject() {
		List<Employee> list=(List<Employee>) repo.findAll();
		//convert each employee to employeedto
		List<EmployeeDto> dto=new ArrayList();
		list.forEach(entity->{
			EmployeeDto edto=new EmployeeDto();
			BeanUtils.copyProperties(entity, edto);
			dto.add(edto);
		});
		return dto;
	}
	
	@Override
	public List<EmployeeDto> findAllObjectById(List<Integer> id) {
		List<Employee> entity=(List<Employee>) repo.findAllById(id);
		List<EmployeeDto> listDto=new ArrayList<EmployeeDto>();
		entity.forEach(row->{
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(row, dto);
			listDto.add(dto);
		});
		
		return listDto;
	}
}//class
