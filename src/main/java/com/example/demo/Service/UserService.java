package com.example.demo.Service;


import com.example.demo.Repository.UserRepository;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUser(long id){
        return userRepository.getReferenceById(id);
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

}












