package com.nt.service;

import com.nt.dto.JobseekerDto;

public interface IJobSeekerServiceMgmt {
	public int saveObject(JobseekerDto dto);
	public JobseekerDto getJobSeekerDetails(int id);

}
