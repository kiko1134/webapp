package com.elsys.webapp.Services;

import com.elsys.webapp.DataAccess.UserRepository;
import com.elsys.webapp.Models.CustomUserDetails;
import com.elsys.webapp.Models.Note;
import com.elsys.webapp.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.NotLinkException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String username, String password){
        Optional<User> user = userRepository.findUserByUsername(username);
        if(user.isPresent()) {
            return;
        }

        userRepository.save(new User(
                username,
                passwordEncoder.encode(password)
        ));
    }

    public CustomUserDetails loadUser(String username){
        Optional<User> user = userRepository.findUserByUsername(username);
        if(user.isEmpty()){
            return null;
        }

        return new CustomUserDetails(user.get());
    }

    public List<Note> getUserNotes(String username){
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isEmpty())
            return List.of();

        return user.get().getNotes();
    }
}
