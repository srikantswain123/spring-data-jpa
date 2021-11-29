package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IComapanyServiceMgmt;

@SpringBootApplication
public class SpringDataAssociationmAppingApplication {

	public static void main(String[] args) {
		//gather Aplication Context Object
		ApplicationContext ctx=SpringApplication.run(SpringDataAssociationmAppingApplication.class, args);
		//create Service class Object
		IComapanyServiceMgmt service=ctx.getBean("compService",IComapanyServiceMgmt.class);
        // invoke business method
		/*service.fetchJoinDetails().forEach(row->{
			for(Object value:row) {
				System.out.print(value+" ");
			}
			System.out.println();
		});*/
		System.out.println("--------------------------------------------------");
		service.fetchJoinDetailsChildToParent().forEach(row->{
			for(Object value:row) {
				System.out.print(value+"  ");
			}
			System.out.println();
		});
		
		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
