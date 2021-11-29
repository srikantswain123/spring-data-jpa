package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Rider;

public interface IriderRepo extends MongoRepository<Rider, Integer> {

}
