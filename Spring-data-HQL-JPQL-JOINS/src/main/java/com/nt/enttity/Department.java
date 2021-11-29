package com.nt.enttity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="Department_OTM")
@Setter
@Getter
@RequiredArgsConstructor
public class Department implements Serializable {
	@Id
	@SequenceGenerator(name="gen1",sequenceName ="dept_seq",initialValue = 500,allocationSize = 10 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
   private Integer dno;
	@NonNull
	@Column(length=20)
   private String dname;
	@NonNull
	@Column(length=20)
   private String company;
	@Column(length=20)
	@NonNull
   private String location;
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "dept")
    @LazyCollection(LazyCollectionOption.EXTRA)  
    @Fetch(FetchMode.JOIN)
	private Set<Employee> emp;
	
	
	public Department() {
    System.out.println("Department.Department()::zero param constructor"+this.getClass());
	}
	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + ", company=" + company + ", location=" + location + "]";
	}
	
}
