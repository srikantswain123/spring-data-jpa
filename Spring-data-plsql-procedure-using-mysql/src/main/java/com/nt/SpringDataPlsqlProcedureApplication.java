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
		service.getAllEmpsDetails("hyd","koembatur").forEach(System.out::println);
	}//main

}//class
