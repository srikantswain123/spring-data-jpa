package com.nt.enttity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Employee_MTO")
@Setter
@Getter
@RequiredArgsConstructor
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer eid;
	@NonNull
	@Column(length = 20)
	private String ename;
	@Column(length = 20)
	@NonNull
	private String eadd;
	@NonNull
	@ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="dept_id",referencedColumnName = "dno")
	private Department dept;
	public Employee() {
	System.out.println("Employee.Employee()::zero param constructor"+this.getClass());
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eadd=" + eadd + "]";
	}

	
	
	 
}
