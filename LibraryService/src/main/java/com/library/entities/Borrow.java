package com.library.entities;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "borrow")
@Entity
@NoArgsConstructor
@Data
public class Borrow {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer borrowId;
	private Integer userId;
	private Date date_of_giving;
	
	@ManyToOne
	@JoinColumn(name = "book_id" ,nullable = false)
	private Book book;
	
}
