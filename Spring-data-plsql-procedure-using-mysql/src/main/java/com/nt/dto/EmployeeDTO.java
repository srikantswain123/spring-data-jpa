package com.nt.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class EmployeeDTO implements Serializable {
	private Integer eid;
	private String ename;
	private  Float esal;
	private String desg;
	private String eadd;

}
