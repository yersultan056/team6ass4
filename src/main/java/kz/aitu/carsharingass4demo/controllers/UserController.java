package kz.aitu.carsharingass4demo.controllers;

import kz.aitu.carsharingass4demo.services.Interfaces.UserServiceInterface;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getById(@PathVariable("user_id") int id){
        User user = service.getById(id);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
