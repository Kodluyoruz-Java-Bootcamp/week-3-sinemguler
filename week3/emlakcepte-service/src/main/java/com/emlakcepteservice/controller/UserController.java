package com.emlakcepteservice.controller;

import com.emlakcepteservice.model.User;
import com.emlakcepteservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired // injection işlemi, spring tarafından oluşan objenin bağlanması. Default tanımı singleton.
    private UserService service;

    // GET /users
    @GetMapping
    public List<User> getAll() {

        System.out.println("getAll - userService :: " + service);
        return service.getAllUser();
    }

    // POST /users
    // @RequestMapping(method = RequestMethod.POST, value = "/saveUser") --best
    // practise ters
    @PostMapping
    // @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<User> create(@RequestBody User user) {
        //UserService service = new UserService();
        service.createUser(user);
        // return user;
        System.out.println("create - userService :: " + service);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // GET /users/{email} -> /users/cemdrman@gmail.com
    @GetMapping(value = "/{email}")
    public User getByEmail(@PathVariable String email) {
        System.out.println("gelen email request'i: " + email);
        //UserService service = new UserService();
        System.out.println("getByEmail - userService :: " + service);
        return service.getByEmail(email);
    }

    //@PathParam

}
