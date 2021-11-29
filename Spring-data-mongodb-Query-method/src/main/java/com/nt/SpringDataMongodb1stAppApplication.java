package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.ICustomerRepo;

@SpringBootApplication
public class SpringDataMongodb1stAppApplication {

	public static void main(String[] args) {
		//create Container
		ApplicationContext ctx=SpringApplication.run(SpringDataMongodb1stAppApplication.class, args);
		ICustomerRepo repo=ctx.getBean(ICustomerRepo.class);
		/*repo.getData("hyd").forEach(row->{
			for(Object obj:row) {
				System.out.print(obj+" ");
			}
			System.out.println();
		});*/
		//repo.getAllData("hyd").forEach(System.out::println);
		//repo.getAllDataOne("hyd", "srikant").forEach(System.out::println);
		//repo.getRegData("i$").forEach(System.out::println);
		//repo.getSalRange(60000, 180000).forEach(System.out::println);
		repo.getDataByOrCond("^s", "delhi").forEach(System.out::println);
		
		//close Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
