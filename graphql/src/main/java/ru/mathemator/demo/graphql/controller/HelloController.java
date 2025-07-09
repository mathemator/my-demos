package ru.mathemator.demo.graphql.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    @QueryMapping
    public String hello() {
        return "Привет, Санёк 😸!";
    }

    @QueryMapping
    public String greet(@Argument String name) {
        return "Здарова, " + name + "!";
    }
}