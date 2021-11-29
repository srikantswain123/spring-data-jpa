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
		
		//System.out.println("Employee Data"+service.getEmployeData(33));
		
		//service.fetchEmployeeByExampleData(new EmployeeDto("sohail","mdh"), true, "eid").forEach(System.out::println);
		try {
		service.removeEmployeeInBatch(List.of(new EmployeeDto(33),new EmployeeDto(34),new EmployeeDto(35)));
		}catch(Exception e) {
			System.out.println("Problem towards object deleted");
			e.printStackTrace();
		}//catch
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
