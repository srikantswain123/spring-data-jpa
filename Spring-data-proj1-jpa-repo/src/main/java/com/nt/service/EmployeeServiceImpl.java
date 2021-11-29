package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDto;
import com.nt.entity.Employee;
import com.nt.repo.EmployeRepo;
@Service("empService")
public class EmployeeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepo repo;
	
	
	 @Override
	 @Transactional
	public EmployeeDto getEmployeData(int eno) {
		Employee entity=repo.getOne(eno);
		EmployeeDto dto=new EmployeeDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	 
	 
	 @Override
	public List<EmployeeDto> fetchEmployeeByExampleData(EmployeeDto dto, boolean asc, String property) {
		 Employee entity=new Employee();
		 BeanUtils.copyProperties(dto, entity);
		 Example<Employee> example=Example.of(entity);
		 List<Employee> listEntity=repo.findAll(example, asc?Sort.by(Direction.ASC, property):Sort.by(Direction.DESC, property));
		 List<EmployeeDto> listDto=new ArrayList<EmployeeDto>();
		 listEntity.forEach(entity1->{
			 EmployeeDto dto1=new EmployeeDto();
			 BeanUtils.copyProperties(entity1, dto1);
			 listDto.add(dto1);
		 });
		 
		 
		return listDto;
	}
	 
	 @Override
	public void removeEmployeeInBatch(List<EmployeeDto> listDto) {
		List<Employee> listEntity=new ArrayList();
		listDto.forEach(dto->{
			Employee entity=new Employee();
			BeanUtils.copyProperties(dto, entity);
			listEntity.add(entity);
		});
		repo.deleteInBatch(listEntity);
	}
	
}//class
