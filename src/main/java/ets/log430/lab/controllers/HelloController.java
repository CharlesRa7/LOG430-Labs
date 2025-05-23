package ets.log430.lab.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String hello() {
        return jdbcTemplate.queryForObject("SELECT name FROM users WHERE id = 1", String.class);
    }
}

