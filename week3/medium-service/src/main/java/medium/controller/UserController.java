package medium.controller;

import medium.model.User;
import medium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mediumusers")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public List<User> getAll(){
        return  userService.getAllUser();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        userService.createUser(user);
        System.out.println("Create - userService :: " + userService);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user, Long id) {
        userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "deleted" + id;
    }

    @GetMapping(value = "/{email}")
    public User getByEmail(@PathVariable String email) {
        System.out.println("gelen email request'i: " + email);
        System.out.println("getByEmail - userService :: " + userService);
        return userService.getByEmail(email);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable() Long id) {
        return userService.getById(id);
    }
}
