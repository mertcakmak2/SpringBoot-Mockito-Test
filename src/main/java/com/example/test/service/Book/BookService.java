package com.example.test.service.Book;

import com.example.test.model.Book;

public interface BookService {

    Book saveBook (Book book);
    Book updateBook (Book book);
    Book findBookById(int id);
}
