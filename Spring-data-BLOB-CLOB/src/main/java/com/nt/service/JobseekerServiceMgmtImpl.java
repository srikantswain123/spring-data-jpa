package com.nt.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.JobseekerDto;
import com.nt.entity.Jobseeker;
import com.nt.repo.JobSeekerRepo;

@Service("service")
public class JobseekerServiceMgmtImpl implements IJobSeekerServiceMgmt {
	
	@Autowired
	private JobSeekerRepo repo;

	@Override
	public int saveObject(JobseekerDto dto) {
		//create entity Object
		Jobseeker entity=new Jobseeker();
		BeanUtils.copyProperties(dto, entity);
		//save Object
		
		return repo.save(entity).getJid();
	}
	
	@Override
	public JobseekerDto getJobSeekerDetails(int id) {
		//get details by entity
		Optional<Jobseeker> opt=repo.findById(id);
		if(opt.isPresent()) {
			//copy entity to dto
			JobseekerDto dto=new JobseekerDto();
			BeanUtils.copyProperties(opt.get(), dto);
			return dto;
		}
		return null;
	}

}
