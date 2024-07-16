package com.library.playloads;

import java.util.Date;

import com.library.entities.Book;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BorrowDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer borrowId;
	private String userId;
	private Date date_of_giving;
	
	
	    private BookDto book;
	    
}
