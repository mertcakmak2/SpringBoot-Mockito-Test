package com.example.test.controller;

import com.example.test.model.Author;
import com.example.test.service.Author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("")
    public ResponseEntity<Author> saveAuthor(@Valid @RequestBody Author author){
        return new ResponseEntity<Author>(authorService.saveAuthor(author), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<Author> findAuthorById(@RequestParam int id){
        return new ResponseEntity<Author>(authorService.findAuthorById(id), HttpStatus.OK);
    }
}
