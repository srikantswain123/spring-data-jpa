package com.nt.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {
	
	
	@Query(fields="{id:0,cno:1,cname:1,cadd:1}",value = "{cadd:?0}")
	public List<Object[]> getData(String addrs);
	
	@Query(value="{cadd:?0}")
	public List<Customer> getAllData(String addrs);
	
	
	@Query(value="{cadd:?0,cname:?1}")
	public List<Customer> getAllDataOne(String cadd,String name);
	
	@Query(value="{cadd:{$regex:?0}}")
	public List<Customer> getRegData(String charsequence);
	
	@Query(value="{sal:{$gt:?0},sal:{$lt:?1}}")
	public List<Customer> getSalRange(int start,int end);
	
    @Query(value="{$or:[{cname:{$regex:?0}},{cadd:?1}]}")
	public List<Customer> getDataByOrCond(String intitchar,String addrs);
	
	
	

}
