package spring.controller.mock_mvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spring.controller.HomeController;
import spring.controller.HomeControllerAdvice;
import spring.service.HomeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MockMvcBuilderIT {

    // 不使用注解，而是使用MockMvcBuilders来build构建MockMvc
    private MockMvc mockMvc;
    private HomeController homeController;

    @BeforeEach
    public void init() {
        // TODO. 使用构造器注入Bean，方便集成测试
        HomeService homeService = Mockito.mock(HomeService.class);
        homeController = new HomeController(homeService);

        // TODO. 必须设置自定义ControllerAdvice测试ExceptionHandler的处理
        mockMvc = MockMvcBuilders.standaloneSetup(homeController)
                .setControllerAdvice(new HomeControllerAdvice())
                .build();
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(content().string("Index Page"));
    }
}
