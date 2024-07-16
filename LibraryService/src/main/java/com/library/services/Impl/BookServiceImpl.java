package com.library.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Book;
import com.library.exception.ResourceNotFoundException;
import com.library.playloads.BookDto;
import com.library.repository.BookRepo;
import com.library.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepo bookRepo;
	
    @Autowired
    private ModelMapper modelMapper;
	@Override
	public BookDto createBook(BookDto bookDto) {
		
	
		 Book book = this.modelMapper.map(bookDto, Book.class);
       Book newBook=this.bookRepo.save(book);
        
		return this.modelMapper.map(newBook,BookDto.class);
	}

	@Override
	public BookDto getBookById(Integer bookId) {
		Book book = this.bookRepo.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "book id", bookId));
        return this.modelMapper.map(book, BookDto.class);	

	}

	@Override
	public List<BookDto> getAllBooks() {
		List<Book> books = this.bookRepo.findAll();
        return books.stream()
                .map(book -> this.modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
	}

	@Override
	public List<BookDto> searchBooks(String keyword) {
		 List<Book> books = this.bookRepo.searchByTitle("%" + keyword + "%");
	        List<BookDto> bookDtos = books.stream().map((book) -> this.modelMapper.map(book, BookDto.class)).collect(Collectors.toList());
	        return bookDtos;
	}

}
