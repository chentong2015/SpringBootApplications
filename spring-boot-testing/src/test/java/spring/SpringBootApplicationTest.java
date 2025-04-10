package spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.config.MyExcludedTestConfig;
import spring.service.HomeService;

// 1. 配置要启动的SpringBoot启动类，否则根据Package包路径查找
// 2. 配置应用启动的随机端口，避免多个测试post冲突
// 3. 设置测试时使用的properties属性
@SpringBootTest(classes = SpringBootTestingApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {"spring.security.user.name=test", "spring.security.user.password=test123"})
// 激活针对于测试的Profile
@ActiveProfiles("test")
// 配置测试时要移除的Configuration
@EnableAutoConfiguration(exclude = MyExcludedTestConfig.class)
// 加载特殊的配置文件用于测试
@ContextConfiguration(locations = {"classpath:spring.bean.MyTestBean"})
@TestPropertySource(locations = "classpath:application-it.properties")
// 为测试添加Extension扩展，控制测试前后执行逻辑
@ExtendWith(SpringExtension.class)
public class SpringBootApplicationTest {

    // TODO. 不能在测试类型中直接添加@Bean方法
    //  Test Class cannot include @Bean methods
    // public MyClass myClass() {
    //     return new MyClass();
    // }

    // 测试Main的启动并从SpringContext中获取注入的bean
    @Test
    public void testSpringBootApplicationMain() {
        SpringBootTestingApplication.main(new String[]{});
        HomeService homeService = ApplicationContextProvider.getBean(HomeService.class);
        homeService.printHome();
    }
}
