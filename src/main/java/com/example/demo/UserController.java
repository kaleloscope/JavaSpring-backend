package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"}, methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    private User user;
    private Integer id;

    @GetMapping()
    public List<User> list(){
        return userService.listAllUser();

    }

    @GetMapping("{id}")
    public ResponseEntity<User> get(@PathVariable Integer id){
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update (@RequestBody User user, @PathVariable Integer id){
        this.user = user;
        this.id = id;
        try {
            User existUser = userService.getUser(id);
            user.setId(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        userService.deleteUser(id);
    }

}
