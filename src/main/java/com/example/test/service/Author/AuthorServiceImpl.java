package com.example.test.service.Author;

import com.example.test.model.Author;
import com.example.test.model.Book;
import com.example.test.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findAuthorById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean existAuthor(int id) {
        return authorRepository.existsById(id);
    }
}
