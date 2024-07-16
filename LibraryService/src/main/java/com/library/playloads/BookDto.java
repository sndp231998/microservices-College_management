package com.library.playloads;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bookId;
	
	private String title;
	
	private String Faculty;
	
	private String price;
	
	private String scancode;
	
	private Integer qty;
}
