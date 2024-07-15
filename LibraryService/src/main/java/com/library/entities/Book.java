package com.library.entities;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "book")
@Entity
@NoArgsConstructor
@Data
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	private String title;
	
	private String isbn;
	
	private double price;

    private String category;
    
    private Integer quantity;
  
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
	private Set<Borrow> borrows=new HashSet<>();
    
    
}
