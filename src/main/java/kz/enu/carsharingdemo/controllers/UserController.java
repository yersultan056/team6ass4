package kz.enu.carsharingdemo.controllers;

import kz.enu.carsharingdemo.services.Interfaces.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kz.enu.carsharingdemo.models.User;
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
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user){
        User createdUser = service.create(user);
        if(createdUser == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping("/surname/{user_surname}")
    public List<User> getAllBySurname(@PathVariable("user_surname") String surname){
        return service.getBySurname(surname);
    }
    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<User> update(@PathVariable("user_id") int id, @RequestBody User user) {
        User updatedUser = service.updateUser(id, user);
        if(updatedUser == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }



}