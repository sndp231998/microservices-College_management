package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.entities.Borrow;
import com.library.services.BorrowService;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    // Endpoint to create a new Borrow
    @PostMapping("/")
    public ResponseEntity<Borrow> createBorrow(@RequestBody Borrow borrow) {
        Borrow createdBorrow = borrowService.createBorrow(borrow);
        return new ResponseEntity<>(createdBorrow, HttpStatus.CREATED);
    }
}
