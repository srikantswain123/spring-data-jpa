package com.nt;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.CustomerDto;
import com.nt.service.IcustomerServiceMgmt;

@SpringBootApplication
public class SpringDataMongodb1stAppApplication {

	public static void main(String[] args) {
		//create Container
		ApplicationContext ctx=SpringApplication.run(SpringDataMongodb1stAppApplication.class, args);
		//get Service class Object
		IcustomerServiceMgmt service=ctx.getBean("custService",IcustomerServiceMgmt.class);
		//invoke business method
		//service.getAllCustomerDetails().forEach(System.out::println);
		//get single record
		/*Optional<CustomerDto> dto=service.getCustomerDetails("600a2240bb159245a00d1423");
		if(dto.isPresent()) {
			System.out.println(dto.get());
		}else {
			System.out.println("Object not found");
		}*/
		//delete object by id
		System.out.println(service.deleteObjectById(null));
		
		
		//close Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
