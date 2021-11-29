package com.nt.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {
	private Integer eid;
	@NonNull
	private String ename;
	@NonNull
	private  Float esal;
	@NonNull
	private String desg;
	
	public  EmployeeDto(int eid) {
		this.eid=eid;
	}

}
