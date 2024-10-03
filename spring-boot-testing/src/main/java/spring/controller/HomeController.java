package spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bean.Request;
import spring.repository.UserRepository;
import spring.service.HomeService;

@RestController
public class HomeController {

    private final HomeService homeService;
    private final UserRepository userRepository;

    public HomeController(HomeService homeService, UserRepository userRepository) {
        this.homeService = homeService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/index")
    public String index() {
        return "Index Page";
    }

    @GetMapping("/greeting")
    @ResponseBody
    public String greeting() {
        return homeService.greet();
    }

    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody Request request) {
        String result = request.getStatus() != null ? "OK" : "Error";
        return ResponseEntity.ok(result);
    }
}
