package org.example.quizzy.service;

import org.example.quizzy.model.User;
import org.example.quizzy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    //

    public User addUser(User user){
        User newUser = userRepository.findByEmail(user.getEmail());
        if(newUser == null){
            user.setPassword(user.getPassword());
            return userRepository.save(user);
        }

        return null;
    }

    public User updatePassword(String newPassword, String oldPassword){
        return null;
    }
}
