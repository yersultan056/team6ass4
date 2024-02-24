package kz.aitu.carsharingass4demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @GetMapping
    public String sayHello(){
        return "Hello World";
    }
}
