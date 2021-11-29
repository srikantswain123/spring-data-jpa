package com.nt.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class JobseekerDto implements Serializable {
	private Integer jid;
	private String jsname;
	private String qlfy;
	private byte[] photo;
	private char[] resume;
	private boolean status;
	

}
