package com.springboot.main.controller.test_empty;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class EmptyResponseRestController {

    @GetMapping("/void")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void testVoid() {
    }

    // TODO. type=Not Acceptable, status=406
    @GetMapping("/no-content")
    public Object testNoContent() {
        return ResponseEntity.noContent();
    }
}
