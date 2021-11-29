package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.StudentDocument;

public interface StudentRepo extends MongoRepository<StudentDocument, String> {

}
