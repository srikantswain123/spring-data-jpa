package com.nt.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.enttity.Department;
import com.nt.enttity.Employee;
import com.nt.repository.DepartmentRepo;
import com.nt.repository.Employeerepo;

@Service("compService")
public class CompanyServiceMgmtImpl implements IComapanyServiceMgmt {
	@Autowired
	private DepartmentRepo drepo;
   @Autowired
	private Employeerepo erepo;

	@Override
	public List<Object[]> fetchJoinDetails() {
		//fetch data from repo to service
		List<Object[]> details=drepo.getJoinResultParentToChild();
		return details;
	}
	@Override
	public List<Object[]> fetchJoinDetailsChildToParent() {
		//fetch data from repo to service
				List<Object[]> details=erepo.getJoinResultChildToParent();
				return details;
	}

}
