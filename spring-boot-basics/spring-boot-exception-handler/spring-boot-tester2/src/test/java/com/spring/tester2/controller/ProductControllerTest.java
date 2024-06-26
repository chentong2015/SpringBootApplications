package com.spring.tester2.controller;

import com.google.common.io.ByteStreams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    // 使用Autowired会自动添加Controller的ExceptionHandler !!
    @Autowired
    private MockMvc mockMvc;

    // TODO. 使用MockMvcBuilders构建，需要配置自定义的ControllerAdvice
    public ProductControllerTest() {
        MockMvc mockMvc1 = MockMvcBuilders.standaloneSetup(new ProductController())
                .setControllerAdvice(new ProductExceptionControllerAdvice())
                .build();
    }

    // TODO. 对Controller测试异常的抛出
    //  抛出异常后会直接被ExceptionHandler接收并处理，返回特定的body和status
    @Test
    void testInsertProduct() throws Exception {
        Resource resource = new ClassPathResource("products.json");
        FileInputStream file = new FileInputStream(resource.getFile());
        byte[] content = ByteStreams.toByteArray(file);

        mockMvc.perform(post("/products/test/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("")); // 返回的response body没有任何的数据
    }

    @Test
    void testInsertProductWithException() throws Exception {
        Resource resource = new ClassPathResource("products1.json");
        FileInputStream file = new FileInputStream(resource.getFile());
        byte[] content = ByteStreams.toByteArray(file);

        mockMvc.perform(post("/products/test/1")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("Product already exists"));
    }
}