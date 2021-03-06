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
class DepartmentHandlerTest {

    @Autowired
    MockMvc mock;

    @Test
    void find() throws Exception {
        mock.perform(get("/departments/{id}", 1))
                .andDo(log())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").isNumber())
        ;
    }

    @Test
    void findEmployees() throws Exception {
        mock.perform(get("/departments/{id}/employees", 1))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
        ;
    }
}