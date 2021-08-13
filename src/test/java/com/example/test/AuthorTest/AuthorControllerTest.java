package com.example.test.AuthorTest;

import com.example.test.model.Author;
import com.example.test.service.Author.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    AuthorService authorService;

    @Test
    void should_return_savedUserControllerTest() throws Exception {
        Author author = Author.builder().id(1).name("Mert Cakmak").build();

        // fake service return method
        Mockito.when(authorService.saveAuthor(author)).thenReturn(author);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/author")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(author)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(author.getId()))
        .andReturn();

        String stringResponse = mvcResult.getResponse().getContentAsString();
        Author actualAuthor = objectMapper.readValue(stringResponse, Author.class);

        assertNotNull(actualAuthor);
        assertEquals(201, mvcResult.getResponse().getStatus());
    }

    @Test
    void should_return_findUserByIdControllerTest() throws Exception {
        Author author = Author.builder().id(1).name("Mert Cakmak").build();

        //Fake service return Method
        Mockito.when(authorService.findAuthorById(author.getId())).thenReturn(author);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/author?id="+author.getId()))
                .andReturn();

        String stringResponse = mvcResult.getResponse().getContentAsString();
        Author actualAuthor = objectMapper.readValue(stringResponse, Author.class);

        assertEquals(200, mvcResult.getResponse().getStatus());
        assertNotNull(actualAuthor.getId());
        assertEquals(author.getId(), actualAuthor.getId());
    }

}