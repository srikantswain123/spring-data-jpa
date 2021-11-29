package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name = "job_Seeker")
public class Jobseeker implements Serializable {
	@Id
	@GeneratedValue
	private Integer jid;
	@Column(length=20)
	private String jsname;
	@Column(length=20)
	private String qlfy;
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;
	private boolean status;
	

}
