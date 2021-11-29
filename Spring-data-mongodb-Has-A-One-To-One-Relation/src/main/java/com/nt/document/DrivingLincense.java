package com.nt.document;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrivingLincense {
	private Integer lid;
	private String type;
	private LocalDate expiryDate;

}
