package com.library.playloads;

import java.util.Date;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReturnbackDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer returnId;
	private Integer userId;
	private Date date_of_Return;

	    private BookDto book;
	    private BorrowDto borrow;
	    }
