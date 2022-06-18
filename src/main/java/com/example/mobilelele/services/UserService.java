package com.example.mobilelele.services;

import com.example.mobilelele.DTO.RegisterUser;
import com.example.mobilelele.models.UserEntity;
import com.example.mobilelele.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }





    public void registerAndLogin(RegisterUser registerUser) {
        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setActive(true);
        newUserEntity.setEmail(registerUser.getEmail());
        newUserEntity.setFirstName(registerUser.getFirstName());
        newUserEntity.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        newUserEntity.setLastName(registerUser.getLastName());

        UserEntity save = this.userRepository.save(newUserEntity);

       // login(save.getEmail());
    }
}
