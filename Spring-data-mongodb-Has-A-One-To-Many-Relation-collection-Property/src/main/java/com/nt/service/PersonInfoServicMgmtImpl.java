package com.nt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.BankAccount;
import com.nt.document.MobileNumber;
import com.nt.document.PersonInfo;
import com.nt.document.Visa;
import com.nt.dto.BankAccountDto;
import com.nt.dto.MobileNumberDto;
import com.nt.dto.PersonInfoDto;
import com.nt.dto.VisaDto;
import com.nt.repo.PersonInfoRepo;

@Service("service")
public class PersonInfoServicMgmtImpl implements IPersonInfoServiceMgmt {
    @Autowired
	private PersonInfoRepo repo;

	@Override
	public String saveObject(PersonInfoDto dto) {
		//copy dto to doc object
		PersonInfo info=new PersonInfo();
		BeanUtils.copyProperties(dto, info);
		Set<MobileNumberDto> setDto=dto.getNumber();
		List<VisaDto> listDto=dto.getVisa();
		Map<String,BankAccountDto> mapDto=dto.getAccount();
		//create special property doc object
		Set<MobileNumber> setDoc=new HashSet<MobileNumber>();
		List<Visa> listDoc=new ArrayList<Visa>();
		Map<String,BankAccount> mapDoc=new HashMap<String, BankAccount>();
		
		//copy each dto collection property to doc object
		setDto.forEach(mdto->{
			MobileNumber number=new MobileNumber();
			BeanUtils.copyProperties(mdto, number);
			setDoc.add(number);
		});
		
		listDto.forEach(ldto->{
			Visa visa=new Visa();
			BeanUtils.copyProperties(ldto, visa);
			listDoc.add(visa);
		});
		
		mapDto.forEach((key,mdto)->{
			BankAccount account=new BankAccount();
			BeanUtils.copyProperties(mdto, account);
			mapDoc.put(key, account);
		});
		info.setNumber(setDoc);
		info.setVisa(listDoc);
		info.setAccount(mapDoc);
		//save Object Using  doc object
		return repo.save(info).getPid()+" id Object saved";
	}

}
