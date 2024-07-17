package com.library.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Returnback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer returnId;
	private Integer userId;
	private Date date_of_Return;
	
	 @ManyToOne
	    @JoinColumn(name = "bookId")
	    private Book book;
	 
	 @ManyToOne
	    @JoinColumn(name = "borrowId")
	    private Borrow borrow;

}
