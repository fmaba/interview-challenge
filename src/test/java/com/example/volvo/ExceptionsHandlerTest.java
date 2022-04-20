package com.example.volvo;

import com.example.volvo.controller.CustomerController;
import com.example.volvo.exception.ExceptionsHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureWebMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExceptionsHandlerTest {

    private MockMvc mockMvc;

    @Mock
    CustomerController controller;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new ExceptionsHandler())
                .build();
    }


    @Test
    public void shouldReturn404ForEmptyResult() throws Exception {
        Mockito.when(controller.delete(any()))
               .thenThrow(EmptyResultDataAccessException.class);
        mockMvc.perform(MockMvcRequestBuilders.delete("/customers/any")).andExpect(status().is(404));
    }
}
