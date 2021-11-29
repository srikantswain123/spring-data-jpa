package com.nt;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeDto;
import com.nt.service.IEmployeService;

@SpringBootApplication
public class SpringDataProj1CrudRepoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataProj1CrudRepoApplication.class, args);
		//invoke business method
		IEmployeService service=ctx.getBean("empService",IEmployeService.class);
		//find object by sort
		//service.findAllObjectBySort("eid", false).forEach(System.out::println);
		
		//service.findAllObjectBySort(true, "desg").forEach(System.out::println);
		
		//find object by pagination
	//	service.findAllObjectByPagination(3, 3).forEach(System.out::println);
		
		service.getAllEmployeeDEtailsByAutoPaging(3);
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
