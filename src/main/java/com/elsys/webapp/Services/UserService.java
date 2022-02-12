package com.elsys.webapp.Services;

import com.elsys.webapp.DataAccess.UserRepository;
import com.elsys.webapp.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, String password){
        Optional<User> user = userRepository.findUserByUsernameAndPassword(username,password);
        if(user.isPresent()) {
            return;
        }

        userRepository.save(new User(username,password));
    }

    public Integer loginUser(String username, String password){
        Optional<User> user = userRepository.findUserByUsernameAndPassword(username,password);
        if(user.isEmpty()){
            return null;
        }

        return user.get().getId();
    }
}
