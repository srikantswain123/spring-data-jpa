package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Jobseeker;

public interface JobSeekerRepo extends JpaRepository<Jobseeker, Integer> {

}
