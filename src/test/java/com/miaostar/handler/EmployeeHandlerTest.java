package com.miaostar.handler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeHandlerTest {

    @Autowired
    MockMvc mock;

    @Test
    void find() throws Exception {
        mock.perform(get("/employees/{id}", 4))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
        ;
    }

    @Test
    void findDepartments() throws Exception {
        mock.perform(get("/employees/{id}/departments", 4))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
        ;
    }
}