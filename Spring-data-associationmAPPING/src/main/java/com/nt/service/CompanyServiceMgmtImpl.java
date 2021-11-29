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
	public void saveObjectUsingParent() {
		//prepare parent Object
		Department dept=new Department("production","IT" , "Koembatur");
		//prepare Child Object
		Employee emps[]= {new Employee("rajat", "hyd", dept),new Employee("sumit","mumbai",dept),new Employee("krishna","delhi",dept)};
		//set child to parent
		dept.setEmp(Set.of(emps[0],emps[1],emps[2]));
		//save Object using Parent
		if(drepo.save(dept).getDno()!=0) {
			System.out.println("Object saved Suceesfully");
		}else {
			System.out.println("problem towards saving object");
		}

	}
	
	@Override
	public void saveObjectUsingChild() {
		       //prepare parent Object
				Department dept=new Department("testing","IT" , "noida");
				//prepare Child Object
				Employee emps[]= {new Employee("manohar", "hyd", dept),new Employee("suraj","mumbai",dept),new Employee("alexa","delhi",dept)};
				//set child to parent
				dept.setEmp(Set.of(emps[0],emps[1],emps[2]));
                 for(Employee emp:emps) {
                	 erepo.save(emp);
                 }
				System.out.println("save object using child");
	}
	@Transactional
	@Override
	public void loadObjectUsingParent() {
		List<Department> listDept=drepo.findAll();
		listDept.forEach(parent->{
			System.out.println("parent "+parent);
			Set<Employee> setEmp=parent.getEmp();
			setEmp.forEach(System.out::println);
		});
		
	}

    @Transactional
	@Override
	public void loadObjectUsingchild() {
		List<Employee> listEmp=erepo.findAll();
		listEmp.forEach(child->{
			System.out.println("child "+child);
			System.out.println(child.getDept().toString());
		});
		
	}

}
