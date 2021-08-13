package com.example.test.service.Author;

import com.example.test.model.Author;

public interface AuthorService {

    Author saveAuthor(Author author);

    Author findAuthorById(int id);

    Boolean existAuthor(int id);
}
