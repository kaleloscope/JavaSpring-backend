package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> listAllUser() {
        return  userRepository.findAll();
    }

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    public  User getUser(Integer id){
        return  userRepository.findById(id).get();

    }
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
