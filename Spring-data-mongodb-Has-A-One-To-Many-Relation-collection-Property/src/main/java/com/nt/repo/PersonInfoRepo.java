package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.PersonInfo;

public interface PersonInfoRepo extends MongoRepository<PersonInfo, Integer> {

}
