package com.demo.library.app.controller;


import com.demo.library.app.dto.request.CategoryResistrationRequest;
import com.demo.library.app.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @MockBean private CategoryService categoryService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders
                .standaloneSetup(new CategoryController(categoryService))
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }
    @Test
    void registerCategoryTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CategoryResistrationRequest request
                = new CategoryResistrationRequest("컴퓨터");
        String param = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/category/add")
                .content(param)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    //FIXME
    @Test
    void deleteCategoryTest() throws Exception {
        mockMvc.perform(delete("/category/1"))
                .andExpect(status().isNoContent())
                .andDo(print());
    }
}
