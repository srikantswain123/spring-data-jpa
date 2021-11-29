package com.nt;

import java.util.UUID;

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
		//System.out.println(service.saveObject(new CustomerDto(102,"gurmuit","ahemdabad",98445.0f)));
		//invoke update mehod
		//System.out.println(service.updateObject(new CustomerDto("600a2240bb159245a00d1423",102,"manoj","delhi",85964.0f)));
		//use own generator 
		System.out.println(service.saveObject(new CustomerDto(UUID.randomUUID().toString().replace("-", "").substring(0,5),102,"manoj","delhi",85964.0f)));
		
		
		//close Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
