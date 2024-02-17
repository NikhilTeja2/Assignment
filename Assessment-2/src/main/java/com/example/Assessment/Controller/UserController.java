package com.example.Assessment.Controller;


import com.example.Assessment.Model.User;
import com.example.Assessment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.OK)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("existById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean exists(@PathVariable("id") int id) {
        return userService.existsById(id);
    }

    @PutMapping("/update")
    public Optional<User> update(@RequestBody User user) {
        return userService.update(user);

    }

    @DeleteMapping("delete")
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") int id) {
        userService.deleteById(id);
    }

    @PostMapping("/existsByEmail")
    public boolean emailExists(@RequestBody User user) {
        String userEmail = user.getEmail();
        return userService.existsByEmail(userEmail);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
        String email = user.getEmail();
        String password1 = user.getPassword1();

        return userService.userLogin(email,password1);
    }



}
