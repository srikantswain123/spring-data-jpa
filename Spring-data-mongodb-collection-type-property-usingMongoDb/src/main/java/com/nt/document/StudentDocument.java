package com.nt.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDocument {
	@Id
	private String id;
	private String name;
	private Integer marks[];
	private List<String> course;
	private Set<Long> number;
	private Map<String,Integer> friends;
	private Properties hubby;

}
