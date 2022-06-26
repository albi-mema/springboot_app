package com.example.demo.Service;


import com.example.demo.Repository.UserRepository;
import com.example.demo.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUser(long id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public List<User> searchUserByName(String name){
        return userRepository.findUsersByName(name);
    }

    public User updateUser(
            long id,
            String name,
            String surname,
            String CardNo,
            String username,
            String password,
            String email){
        User user = userRepository.getReferenceById(id);
        System.out.println(user);
        user.setName(name);
        user.setSurname(surname);
        user.setCardNo(CardNo);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}












