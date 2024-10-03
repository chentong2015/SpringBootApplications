package spring.controller.rest_template;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

// Tomcat started on port 64740 (http)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringRestTemplateTest {

    // 使用本地启动的随机端口进行测试，避免8080端口冲突
    @LocalServerPort
    private int port;

    // 自动注入TestRestTemplate用于发送http请求，测试Endpoint
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void greetingShouldReturnDefaultMessage() {
        String url = "http://localhost:" + port + "/";
        assertThat(this.restTemplate.getForObject(url, String.class)).contains("home");
    }
}
