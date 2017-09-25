package com.basaki.cloud.author.controller;

import com.basaki.cloud.author.boot.TestAuthorApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import com.basaki.cloud.author.model.Author;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TestAuthorApplication.class)
public class AuthorControllerMockMvcTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                //.apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    public void withUserRequestPostProcessor() throws Exception {
        mockMvc.perform(get("/authors/1"))
                //.with(user("userAx").roles("AUTHOR_USER")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(
                        "application/json;charset=UTF-8")).andDo(
                MockMvcResultHandlers.print());

        MvcResult result = mockMvc.perform(get("/authors/1"))
                //.with(user("userAx").roles("AUTHOR_USER")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(
                        "application/json;charset=UTF-8")).andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        //        String uri = "";
        //        ObjectMapper mapper = new ObjectMapper();
        //        Author author = new Author();
        //        author.setAuthor("indra");
        //        author.setBiography("hello there");
        //        mockMvc.perform(MockMvcRequestBuilders.post("/authors").with(user(
        //                "userAx").roles("AUTHOR_USER"))
        //                .content(mapper.writeValueAsString(author))
        //                .contentType(MediaType.APPLICATION_JSON)
        //                .accept(MediaType.APPLICATION_JSON))
        //                .andExpect(status().isOk())
        //                .andDo(MockMvcResultHandlers.print());
    }
}
