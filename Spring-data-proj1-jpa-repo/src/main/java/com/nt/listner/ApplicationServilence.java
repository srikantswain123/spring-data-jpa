package com.nt.listner;

import java.time.LocalDate;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component("listner")
public class ApplicationServilence implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		long start=0l,end=0l;
		
		if(event.toString().indexOf("ContextRefreshed")!=-1) {
			start=System.currentTimeMillis();
			System.out.println("Application started at::"+LocalDate.now());
		}else if(event.toString().indexOf("ContextClosed")!=-1) {
			end=System.currentTimeMillis();
			System.out.println("Application stopped at::"+LocalDate.now());
			System.out.println("application runnig time "+(end-start)+" ms");
		}
		
	};

}
