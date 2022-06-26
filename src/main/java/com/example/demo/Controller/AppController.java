package com.example.demo.Controller;


import com.example.demo.Entities.Spid;
import com.example.demo.Entities.User;
import com.example.demo.Service.SpidService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class AppController {
    @Autowired
    UserService userService;

    @Autowired
    SpidService spidService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/spids")
    public ResponseEntity<List<Spid>> getSpids(){
        return new ResponseEntity(spidService.getAllSpid(),HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable("id") long id) {
        return new ResponseEntity(userService.getUser(id),HttpStatus.OK);
    }

    @GetMapping("/spids/{id}")
    public ResponseEntity<Optional<Spid>> getSpid(@PathVariable("id") long id) {
        return new ResponseEntity(spidService.getSpid(id),HttpStatus.OK);
    }

    @PostMapping("/users/create_user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity(userService.createUser(user),HttpStatus.OK);

    }

    @PutMapping("/users/{id}/editUser")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id,@RequestBody User user){
        return new ResponseEntity(userService.updateUser(
                id,
                user.getName(),
                user.getSurname(),
                user.getCardNo(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail()),HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}/deleteUser")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/users/{id}/createSpid")
    public  ResponseEntity<Optional<Spid>> createSpid(@PathVariable("id") long id){
        User user = userService.getUser(id).get();
        return new ResponseEntity(spidService.createSpid(user),HttpStatus.OK);
    }

    @PostMapping("/users/{id}/updateSpid")
    public  ResponseEntity<Spid> updateSpid(@PathVariable("id") long id){
        return new ResponseEntity(spidService.changeSpidStatu(id),HttpStatus.OK);
    }











}
