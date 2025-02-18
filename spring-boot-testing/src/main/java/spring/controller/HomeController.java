package spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.RequestContent;
import spring.service.HomeService;

@RestController
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
       this.homeService = homeService;
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
    private String greeting() {
        return homeService.greet();
    }

    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody RequestContent request) {
        String result = request.getStatus() != null ? "OK" : "Error";
        return ResponseEntity.ok(result);
    }
}
