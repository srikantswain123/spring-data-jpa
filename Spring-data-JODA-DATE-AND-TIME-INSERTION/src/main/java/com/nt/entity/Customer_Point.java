package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
public class Customer_Point {
	@Id
	@GeneratedValue
	public Integer custId;
	@Column(length = 20)
	@Type(type = "string")
	public String custName;
	private Float custBillAmt;
	private LocalDate dob;
	private LocalTime tob;
	private LocalDateTime doj;

}
