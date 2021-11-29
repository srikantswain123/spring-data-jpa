package com.nt;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.document.DrivingLincense;
import com.nt.document.Rider;
import com.nt.repo.IriderRepo;

@SpringBootApplication
public class SpringDataMongodbHasAOneToOneRelationApplication {

	public static void main(String[] args) {
		//get container
		
		ApplicationContext ctx=SpringApplication.run(SpringDataMongodbHasAOneToOneRelationApplication.class, args);
		//create repo proxy object
		IriderRepo repo=ctx.getBean(IriderRepo.class);
		//create ride objet with license Object
		Rider rider=new Rider(new Random().nextInt(60000), "gurmit", "delhi", new DrivingLincense(new Random().nextInt(50000),"LMVI",LocalDate.of(2040,02, 25)));
		//save oBject using rider object
	System.out.println(repo.save(rider).getRid()+" id object saved");
   //close container
	((ConfigurableApplicationContext) ctx).close();
	}

}
