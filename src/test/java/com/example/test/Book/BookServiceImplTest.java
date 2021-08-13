package com.example.test.Book;

import com.example.test.model.Author;
import com.example.test.model.Book;
import com.example.test.service.Book.BookService;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookServiceImplTest {

    @MockBean
    BookService bookService;

    @Test
    void should_return_savedBookServiceTest(){
        Book book = getBook();

        Mockito.when(bookService.saveBook(book)).thenReturn(book);
        Book actualBook = bookService.saveBook(book);

        assertNotNull(actualBook.getId());
        assertEquals(book.getBookName(), actualBook.getBookName());
        assertEquals(book.getAuthor().getId(), actualBook.getAuthor().getId());
    }

    @Test
    void should_return_UpdateBookServiceTest(){
        Book book = getBook();

        Mockito.when(bookService.updateBook(book)).thenReturn(book);
        Book actualBook = bookService.updateBook(book);

        assertEquals(book.getId(), actualBook.getId());
        assertEquals(book, actualBook);
    }

    @Test
    void should_return_existBookByIdServiceTest(){
        Book book = getBook();

        Mockito.when(bookService.findBookById(book.getId())).thenReturn(book);
        Book actualBook = bookService.findBookById(book.getId());

        assertEquals(book.getId(), actualBook.getId());

    }

    Book getBook(){
        Author author = Author.builder().id(1).name("Mert Cakmak").build();
        Book book = Book.builder().bookName("Test Book").author(author).build();
        return book;
    }
}
