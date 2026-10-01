package com.colonia.CrudBasic.Controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class HelloWorldController {
    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<String>("Hello World", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/teste")
    public String index() {
        return "index";
    }


}
