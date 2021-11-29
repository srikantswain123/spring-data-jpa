package com.nt.document;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonInfo {
	@Id
	private Integer pid;
	private String name;
	private String addrs;
	private Set<MobileNumber> number;
	private List<Visa> visa;
    private Map<String,BankAccount> account;
	

}
