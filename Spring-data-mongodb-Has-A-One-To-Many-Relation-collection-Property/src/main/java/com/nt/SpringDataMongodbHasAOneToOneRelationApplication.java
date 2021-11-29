package com.nt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.BankAccountDto;
import com.nt.dto.MobileNumberDto;
import com.nt.dto.PersonInfoDto;
import com.nt.dto.VisaDto;
import com.nt.service.IPersonInfoServiceMgmt;

@SpringBootApplication
public class SpringDataMongodbHasAOneToOneRelationApplication {

	public static void main(String[] args) {
		//get container
		
		ApplicationContext ctx=SpringApplication.run(SpringDataMongodbHasAOneToOneRelationApplication.class, args);
		//get Service Object
		IPersonInfoServiceMgmt service=ctx.getBean("service",IPersonInfoServiceMgmt.class);
		//craete Dto Object
		PersonInfoDto dto=new PersonInfoDto(new Random().nextInt(846879), "allen", "mumbai",
				Set.of(new MobileNumberDto(956845755l,"Prepaired")),
				List.of(new VisaDto(new Random().nextInt(54894),"USA",LocalDate.of(2030, 12, 25))),
				Map.of("Account1",new BankAccountDto(213456789l,"saving",7894564.0f),"Account2",new BankAccountDto(8946564l,"current",9846464.0f),"Account3",new BankAccountDto(52489745l,"merchant",9658771.0f)));
		//invoke Business Method
		System.out.println(service.saveObject(dto));
	((ConfigurableApplicationContext) ctx).close();
	}

}
