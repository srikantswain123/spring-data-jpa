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
		/*repo.findByEaddIn(List.of("delhi","mumbai","hyd")).forEach(view->{
		  System.out.println(view.getEid()+"   "+view.getEname());
		});*/
		
		repo.findByEnameStartingWith("j").forEach(view->{
			System.out.println(view.getEid()+"  "+view.getEname()+" "+view.getEsal());
		});
		
		
	}

}
