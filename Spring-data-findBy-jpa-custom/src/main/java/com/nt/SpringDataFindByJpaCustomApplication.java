package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repo.EmployeRepo;

@SpringBootApplication
public class SpringDataFindByJpaCustomApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataFindByJpaCustomApplication.class, args);
		EmployeRepo repo=ctx.getBean(EmployeRepo.class);
		System.out.println("proxy class "+repo.getClass());
		//repo.findByEid(36).forEach(System.out::println);
		//System.out.println("---------------------------------------");
		//repo.findByename("sohail").forEach(System.out::println);
		//repo.findByesalLessThan(100000.0f).forEach(System.out::println);
		//repo.findByesalGreaterThanEqual(100000.0f).forEach(System.out::println);
	    //repo.findByenameLike("j%").forEach(System.out::println);
	    //repo.findByenameStartingWith("s").forEach(System.out::println);
		//repo.findByenameContaining("i").forEach(System.out::println);
		//repo.findByeaddIn(List.of("hyd","mumbai","delhi")).forEach(System.out::println);
		//repo.findByeaddNotIn(List.of("hyd","mumbai")).forEach(System.out::println);;
		//repo.findByeaddIsNull().forEach(System.out::println);
		//repo.findByeaddIsNotNull().forEach(System.out::println);
        //repo.findByeaddIgnoreCase("hyd").forEach(System.out::println);;
	    //repo.findByEaddOrderByEidAsc("hyd").forEach(System.out::println);
	    //repo.findByEnameAndEadd("sunit", "delhi").forEach(System.out::println);
	    //repo.findByEsalOrEadd(100000.0f, "hyd").forEach(System.out::println);
	    //repo.findByEsalBetween(46454.0f,100000.0f).forEach(System.out::println);
		//repo.findByEidAndEnameEndingWithOrEsalBetween(36, "jubain", 10000.0f, 100000.0f).forEach(System.out::println);
	    repo.findByEnameInOrEaddIn(List.of("jumit","junit","sumit"), List.of("hyd","mumbai","delhi")).forEach(System.out::println);
	
	}

}
