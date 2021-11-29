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
		//invoke method
		try {
			//save object using parent
			//service.saveObjectUsingParent();
			//save object using child
			//service.saveObjectUsingChild();
			
			//load object using parent
			//service.loadObjectUsingParent();
			
			//load object using child
			service.loadObjectUsingchild();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
