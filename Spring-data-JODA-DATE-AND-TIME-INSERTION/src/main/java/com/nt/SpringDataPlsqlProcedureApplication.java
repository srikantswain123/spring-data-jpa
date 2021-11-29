package com.nt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.dto.CustomerDto_Point;
import com.nt.service.ICustomerService;

@SpringBootApplication
public class SpringDataPlsqlProcedureApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataPlsqlProcedureApplication.class, args);
		//craate Service Object using Bean
		ICustomerService service=ctx.getBean("customerService",ICustomerService.class);
		//create Dto class Object
		/*CustomerDto_Point dto=new CustomerDto_Point();
		dto.setCustName("gurmit");
		dto.setCustBillAmt(78954.0f);
		dto.setDob(LocalDate.of(1996, 06, 25));
		dto.setTob(LocalTime.of(12, 36, 40));
		dto.setDoj(LocalDateTime.now());
		//invoke service method
		System.out.println(service.saveObject(dto)!=0?"::id Object saved":"Object not saved");*/
		//fetching all customer details
		service.getAllCustomerDetails().forEach(System.out::println);
		
	}//main

}//class
