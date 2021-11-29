package com.nt.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInfoDto {
	private Integer pid;
	private String name;
	private String addrs;
	private Set<MobileNumberDto> number;
	private List<VisaDto> visa;
    private Map<String,BankAccountDto> account;
	

}
