package spring.controller.web_client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

// 必须使用RANDOM_PORT随机端口测试
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class SpringWebClientTest {

    // @AutoConfigureWebTestClient自动装配WebTestClient Bean
    @Autowired
    private WebTestClient webClient;

    @Test
    void whenGetBooksThenReturn() {
        webClient.get().uri("/")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(String.class)
                .isEqualTo("home");
    }
}
