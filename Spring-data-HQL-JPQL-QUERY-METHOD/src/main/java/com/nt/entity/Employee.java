package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
@Data
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer eid;
	@Column(length = 20)
	@Type(type = "string")
	private String ename;
	@Type(type = "float")
	private  Float esal;
	@Column(length = 20)
	@Type(type = "string")
	private String desg;
	@Column(length = 20)
	@Type(type = "string")
	private String eadd;

}
