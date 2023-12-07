package com.example.lab11.Controller;


import com.example.lab11.Model.User;
import com.example.lab11.Service.UserService;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor

public class UserController {


    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAllUser() {

        return ResponseEntity.status(200).body(userService.getAllUses());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addUses(user);
        return ResponseEntity.status(200).body("user added");

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        User userUpdate = userService.updateUser(id, user);
        return ResponseEntity.status(200).body(userUpdate);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);

        return ResponseEntity.status(200).body("user deleted");
    }


    @GetMapping("/check/{username}/{password}")
    public ResponseEntity check(@PathVariable String username, @PathVariable String password) {

        User user = userService.Check(username, password);
        return ResponseEntity.status(200).body(user);


    }
}

