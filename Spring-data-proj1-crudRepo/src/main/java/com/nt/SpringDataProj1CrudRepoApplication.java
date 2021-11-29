package com.nt;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeDto;
import com.nt.service.IEmployeService;

@SpringBootApplication
public class SpringDataProj1CrudRepoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataProj1CrudRepoApplication.class, args);
		//invoke business method
		IEmployeService service=ctx.getBean("empService",IEmployeService.class);
		EmployeeDto dto=new EmployeeDto("suresh",4564.0f , "manager");
		//System.out.println("save emloyee Object Is::"+service.saveObject(dto));
		//update Object
		EmployeeDto dto1=new EmployeeDto(27,"suresh",85685.0f , "analyst");
		//System.out.println("update Object  is::"+service.updateObject(dto1));
		
		//save all object
		/*System.out.println("group object saved ids are::"+Arrays.toString(service.groupRegistration(List.of(new EmployeeDto("mahesh", 46454.0f, "analyst"),
				new EmployeeDto("jumit", 46454.0f, "salesman"),new EmployeeDto("albert", 8559.0f, "spaceman")))));*/
		//count objects
		//System.out.println("total objects are::"+service.objectCounts());
		
		//delete object by existing id
		//System.out.println(service.deleteObject(30));
		
		//find object 
		/*Optional<EmployeeDto> opt=service.findObjectById(125);
		if(opt.isPresent())
			System.out.println("object found "+opt.get());
		else
			System.out.println("Object not found");*/
		
		//delete object by entity
		//System.out.println(service.deleteObjectByEntity(25));
		
		//delete group of object by entity
		/*try {
		System.out.println(service.removeObjectBYEntity(List.of(new EmployeeDto(26),new EmployeeDto(27),new EmployeeDto(28))));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//get All Object
		//service.findAllObject().forEach(System.out::println);
		
		//get All object by id
		service.findAllObjectById(List.of(29,30,31)).forEach(System.out::println);
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
