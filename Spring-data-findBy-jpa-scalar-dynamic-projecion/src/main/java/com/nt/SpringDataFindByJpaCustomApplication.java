package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repo.EmployeRepo;
import com.nt.view.ResultView1;
import com.nt.view.ResultView2;
import com.nt.view.ResultView3;

@SpringBootApplication
public class SpringDataFindByJpaCustomApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataFindByJpaCustomApplication.class, args);
		EmployeRepo repo=ctx.getBean(EmployeRepo.class);
		List<ResultView1> list1=repo.findByEid(36, ResultView1.class);
		list1.forEach(view1->{
			System.out.println(view1.getEname()+" "+view1.getEid());
		});
		System.out.println("---------------------------------");
		List<ResultView2> list2=repo.findByEid(36, ResultView2.class);
		list2.forEach(view2->{
			System.out.println(view2.getEname()+" "+view2.getDesg()+" "+view2.getEsal());
		});
		System.out.println("-----------------------------------");
		List<ResultView3> list3=repo.findByEid(36, ResultView3.class);
		list3.forEach(view3->{
			System.out.println(view3.getEname());
		});
		
	}

}
