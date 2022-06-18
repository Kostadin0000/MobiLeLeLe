package com.example.mobilelele.services;

import com.example.mobilelele.DTO.RegisterUser;
import com.example.mobilelele.DTO.UserLogin;
import com.example.mobilelele.enums.RoleEnum;
import com.example.mobilelele.models.User;
import com.example.mobilelele.models.UserRole;
import com.example.mobilelele.repositories.UserRepository;

import com.example.mobilelele.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(UserLogin userLogin) {

        Optional<User> optionalUser = this.userRepository.findByEmail(userLogin.getUsername());


        if (optionalUser.isEmpty()) {
            return false;
        }

        String rawPassword = userLogin.getPassword();
        String password = optionalUser.get().getPassword();

        return passwordEncoder.matches(rawPassword, password);
    }

    public void login(String email) {
        Optional<User> optionalUser = this.userRepository.findByEmail(email);

        List<RoleEnum> roleEnums = optionalUser
                .get()
                .getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toList());

        currentUser.setLoggedIn(true);
        currentUser.setName(optionalUser.get().getFirstName());
        currentUser.setEmail(optionalUser.get().getEmail());
        currentUser.setRoles(roleEnums);
    }

    public void logout() {
        currentUser.clear();
    }

    public void registerAndLogin(RegisterUser registerUser) {
        User newUser = new User();
        newUser.setActive(true);
        newUser.setEmail(registerUser.getEmail());
        newUser.setFirstName(registerUser.getFirstName());
        newUser.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        newUser.setLastName(registerUser.getLastName());

        User save = this.userRepository.save(newUser);

        login(save.getEmail());
    }
}
