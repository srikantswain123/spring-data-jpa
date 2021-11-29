package com.nt;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.document.StudentDocument;
import com.nt.repo.StudentRepo;

@SpringBootApplication
public class SpringDataMongodbCollectionTypePropertyUsingMongoDbApplication {

	public static void main(String[] args) {
		//create Container
		
		ApplicationContext ctx=SpringApplication.run(SpringDataMongodbCollectionTypePropertyUsingMongoDbApplication.class, args);
	//get repo proxy object
		StudentRepo repo=ctx.getBean(StudentRepo.class);
		Properties prop=new Properties();
		prop.put("mohit", "cricket");
		prop.put("gurmit","singer");
		prop.put("allen", "actor");
		//create document object
		StudentDocument document=new StudentDocument(UUID.randomUUID().toString().replace("-", ""),
				"mohit", 
				new Integer[] {58, 65, 95},
				List.of("c","java","spring","hibernate"),
				Set.of(987745l,988464456l,684894l),Map.of("rohit",37,"gurmit",32,"kartik",48),prop);
		//save Object
		document=repo.save(document);
		System.out.println(document.getId()+" id Object saved");
		//close Container
		((ConfigurableApplicationContext) ctx).close();
	
	
	}

}
