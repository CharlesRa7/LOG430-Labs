package ets.log430.sales.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }
}

