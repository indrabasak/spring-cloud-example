package com.basaki.cloud.author.controller;

import com.basaki.cloud.author.boot.TestAuthorApplication;
import com.basaki.cloud.author.model.Author;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TestAuthorApplication.class)
public class AuthorControllerTemplateTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRead() throws Exception {
        ResponseEntity<Author> response =
                restTemplate.getForEntity("/authors/1", Author.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println(response.getBody());
    }
}
