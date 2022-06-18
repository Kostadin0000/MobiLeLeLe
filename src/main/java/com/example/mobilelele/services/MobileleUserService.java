package com.example.mobilelele.services;


import com.example.mobilelele.models.UserEntity;
import com.example.mobilelele.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public class MobileleUserService implements UserDetailsService {

    private final UserRepository userRepository;


    public MobileleUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // The purpose of this method is to map our UserEntity representation to the UserDetails representation Spring security world
        // The only thing that spring will provide for us is the username.
        // The username will come from the HTML form.

        UserEntity optionalUser = this.userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found"));


        return mapToUserDetails(optionalUser);
    }

    private UserDetails mapToUserDetails(UserEntity optionalUser) {


        // GrantedAuthority is the representation of a User role in the spring world.
        // SimpleGrantedAuthority is an implementation of GrantedAuthority which spring provides for us.
        // Our representation of role is UserRoleEntity.
        List<GrantedAuthority> authorities = optionalUser
                .getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName().name()))
                .collect(Collectors.toList());

        //User is the spring impl of UserDetails interface.
        return new User(optionalUser.getEmail(), optionalUser.getPassword(), authorities);
    }

}
