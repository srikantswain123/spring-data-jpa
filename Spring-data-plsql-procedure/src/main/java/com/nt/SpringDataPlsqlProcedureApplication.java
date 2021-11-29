package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IEmployeeService;

@SpringBootApplication
public class SpringDataPlsqlProcedureApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataPlsqlProcedureApplication.class, args);
		IEmployeeService service=ctx.getBean("empService",IEmployeeService.class);
		//invoke method
		//service.getEmpsBysalRange(10000, 90000).forEach(System.out::println);
		
		service.getEMpsSepecificColumnValues("hyd", "delhi").forEach(row->{
			System.out.println(row[0]+" "+row[1]+" "+row[2]);
		});
	}//main

}//class
