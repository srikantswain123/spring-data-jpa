package com.nt;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.JobseekerDto;
import com.nt.service.IJobSeekerServiceMgmt;

@SpringBootApplication
public class SpringDataBlobClobApplication {

	public static void main(String[] args) {
		//create container
		ApplicationContext ctx=SpringApplication.run(SpringDataBlobClobApplication.class, args);
		//create Service class Object
		IJobSeekerServiceMgmt service=ctx.getBean("service",IJobSeekerServiceMgmt.class);
		//invoke method
		//create Scanner Object
	/*	Scanner scn=new Scanner(System.in);
		System.out.println("Enter name");
		String name=scn.next();
		System.out.println("Enter qulification");
		String qlfy=scn.next();
		System.out.println("Enter photolocation");
		String photo=scn.next();
		System.out.println("Enter resume location");
		String resume=scn.next();
		try {
			//craeate input stream object
			InputStream is=new FileInputStream(photo);
			byte[] bytes=new byte[is.available()];
			//read input stream
			is.read(bytes);
			//create charecter reader object
			File file=new File(resume);
			Reader reader=new FileReader(file);
			char[] ch=new char[(int)file.length()];
			reader.read(ch);
			//set value to dto object
			JobseekerDto dto=new JobseekerDto();
			dto.setJsname(name);
			dto.setQlfy(qlfy);
			dto.setPhoto(bytes);
			dto.setResume(ch);
			dto.setStatus(true);
			
			int result=service.saveObject(dto);
			System.out.println(result!=0?result+" :id Object saved":"Object not saved");
			//close coninaer
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		//fetch data from db
		JobseekerDto dto=service.getJobSeekerDetails(1);
		try {
		if(dto!=null) {
			System.out.println(dto.getJsname()+" "+dto.getQlfy()+" "+dto.getJid());
			OutputStream os=new FileOutputStream("baby.jpg");
			os.write(dto.getPhoto());
			//write resume
			Writer writer=new FileWriter("resume.txt");
			writer.write(dto.getResume());
			//close streams
			os.flush();
			writer.flush();
			os.close();
			writer.close();
		}else {
			System.out.println("record not found");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		 ((ConfigurableApplicationContext) ctx).close();
	}

}
