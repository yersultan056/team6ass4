package kz.aitu.carsharingass4demo.controllers;

import kz.aitu.carsharingass4demo.services.Interfaces.UserServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kz.aitu.carsharingass4demo.models.User;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserServiceInterface service;

    public UserController(UserServiceInterface service) {
        this.service = service;
    }

    @GetMapping("hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/")
    public List<User> getAll(){
        return service.getAll();
    }
}
