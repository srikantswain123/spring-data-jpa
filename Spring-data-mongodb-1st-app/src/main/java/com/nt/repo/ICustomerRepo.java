package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {

}
