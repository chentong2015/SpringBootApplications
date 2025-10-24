package com.springboot.main.controller.test_empty;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class EmptyResponseController {

    @GetMapping("/void")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void testVoid() {
    }

    // TODO. Internal Server Error, status=500
    // Circular view path [no-content]: would dispatch back to the current handler URL [/no-content] again.
    @GetMapping("/no-content")
    public Object testNoContent() {
        return ResponseEntity.noContent();
    }

}
