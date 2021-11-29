package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public List<EmployeeDto> findAllObjectBySort(String property, boolean asc) {
		List<Employee> listEntity=(List<Employee>) repo.findAll(asc?Sort.by(Direction.ASC, property):Sort.by(Direction.DESC, property));
		//convert each entity to dto
		List<EmployeeDto> listDto=new ArrayList();
		listEntity.forEach(entity->{
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			listDto.add(dto);
		});
		
		
		return listDto;
	}
	
	@Override
	public List<EmployeeDto> findAllObjectByPagination(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		Page<Employee> page=repo.findAll(pageable);
		List<Employee> listEntity=page.getContent();
		List<EmployeeDto> listDto=new ArrayList();
		
		listEntity.forEach(entity->{
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			listDto.add(dto);
		});
		return listDto;
	}//method
	
	
	@Override
	public List<EmployeeDto> findAllObjectBySort(boolean asc, String... properties) {
		List<Employee> listEntity=(List<Employee>) repo.findAll(asc?Sort.by(Direction.ASC, properties):Sort.by(Direction.DESC, properties));
		//convert each entity to dto
		List<EmployeeDto> listDto=new ArrayList();
		listEntity.forEach(entity->{
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			listDto.add(dto);
		});
		return listDto;
	}
	
	@Override
	public void getAllEmployeeDEtailsByAutoPaging(int pageSize) {
		long count=repo.count();
		
		int pagesCount=(int) (count/pageSize);
		
		if(count%pageSize!=0)
			pagesCount++;
		
		for(int i=0;i<pagesCount;++i) {
			Pageable pagable=PageRequest.of(i, pageSize);
			Page<Employee> page=repo.findAll(pagable);
			List<Employee> listEntity=page.getContent();
			listEntity.forEach(System.out::println);
			System.out.println(page.getNumber()+1+" of "+page.getTotalPages());
		}
		
		
	}
}//class
