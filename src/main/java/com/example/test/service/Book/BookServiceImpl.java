package com.example.test.service.Book;

import com.example.test.model.Book;
import com.example.test.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Book existBook = findBookById(book.getId());
        if(existBook != null){
            existBook = book;
        }
        bookRepository.save(existBook);
        return existBook;
    }

    @Override
    public Book findBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
