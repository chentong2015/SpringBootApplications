package spring.mock_mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import spring.model.RequestContent;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcDemo2IT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void get_index() throws Exception {
        mockMvc.perform(get("/index").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Index Page"));
    }

    @Test
    void test_with_param() throws Exception {
        MvcResult result = mockMvc.perform(post("/accounts/login.action")
                        .param("username", "20116524")
                        .param("password", "Password"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isSuccessful").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isUsernameEmpty").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isPasswordEmpty").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isAccountValid").value(false))
                .andReturn();

        String body = result.getResponse().getContentAsString();
        System.out.println(body);
        Assertions.assertNotNull(result);
    }

    @Test
    void testPostMethod() throws Exception {
        RequestContent requestContent = new RequestContent(10, "test objects", "none", "123");
        String jsonObject = new ObjectMapper().writeValueAsString(requestContent);

        mockMvc.perform(post("/post")
                        .content(jsonObject)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }
}
