package com.example.test.AuthorTest;

import com.example.test.model.Author;
import com.example.test.repository.AuthorRepository;
import com.example.test.service.Author.AuthorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorServiceImplTest {

    @Autowired
    AuthorService authorService;

    @MockBean
    AuthorRepository authorRepository;

    @Test
    void should_return_savedAuthorServiceTest(){
        Author author = Author.builder().id(1).name("Mert Cakmak").build();

        //Fake Repository return Method
        Mockito.when(authorService.saveAuthor(author)).thenReturn(author);

        Author actualAuthor = authorService.saveAuthor(author);

        assertNotNull(actualAuthor.getId());
        assertEquals(author.getId(), actualAuthor.getId());

    }

    @Test
    void should_return_findAuthorByIdUserServiceTest(){
        Author author = Author.builder().id(1).name("Mert Cakmak").build();

        //Fake Repository return Method
        //Mockito.when(authorService.existAuthor(author.getId())).thenReturn(true);
        Mockito.when(authorRepository.findById(author.getId())).thenReturn(java.util.Optional.of(author));

        Author actualAuthor = authorService.findAuthorById(author.getId());

        assertEquals(author.getId(), actualAuthor.getId());
    }

}