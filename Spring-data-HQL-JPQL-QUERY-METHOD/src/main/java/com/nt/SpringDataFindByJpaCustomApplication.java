package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repo.EmployeRepo;

@SpringBootApplication
public class SpringDataFindByJpaCustomApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataFindByJpaCustomApplication.class, args);
		EmployeRepo repo=ctx.getBean(EmployeRepo.class);
		//repo.getAllEmployeeDeatilsByAddrs("hyd").forEach(System.out::println);
		/*System.out.println("-----------------------------");
		repo.fetchAllEmployeBysal(10000.0f, 1000000.0f).forEach(System.out::println);*/
		//retriving specific column values
		/*repo.fectchEmpDetailsByCities("hyd", "delhi", "mumbai").forEach(row->{
			System.out.println(row[0]+"   "+row[1]);
		});
		*/
		
		/*repo.fecthEpDetailsByNameIitChars("j").forEach(row->{
			System.out.println(row[0]+"  "+row[1]);
		});*/
		
		//------------------fetch single column values
		//repo.findEmpNamesByEidRange(30, 40).forEach(System.out::println);
		
		//retirving single row column values
		//System.out.println(repo.findAllEmployeeDetailsByEid(30));
		
		/*Object object[]=(Object[]) repo.findEMployeePartialDetailsBYEid(30);
		System.out.println(object[0]+"  "+object[1]);*/
		
		//System.out.println(repo.findEmployeeSalaryByEid(30));
		//retriving agragte function
		//System.out.println("EMployee counts "+repo.getEmployeCounts());
		
		/*Object obj[]=(Object[]) repo.getEmpsAgregateData();
		System.out.println("Employe Counts "+obj[0]+" Max salary "+obj[1]+" Min salary "+obj[2]+" Avg salary "+obj[3]);
		*/
		
		/*int count=repo.updateEMpsBysal(1000, 100000);
		System.out.println(count+" row are updated");*/
		
		/*int count=repo.deleteEmployeNullEadd();
		System.out.println(count+" EMployes are deleted");*/
		//native sql
		
		//System.out.println(repo.getSysDate());
		
		//insert query
		int count=repo.insertEmployeeUsingNativeSQl(154, "MANGER", "dosang", 12456.0f, "vizag");
		System.out.println(count+" EMployes are Inserted");
	}

}
