package com.example.mobilelele.services;


import com.example.mobilelele.models.UserEntity;
import com.example.mobilelele.models.UserRole;
import com.example.mobilelele.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class MobileleUserService implements UserDetailsService {

    private final UserRepository userRepository;


    public MobileleUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository.
                findByEmail(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {
        return
                User.builder().
                        username(userEntity.getEmail()).
                        password(userEntity.getPassword()).
                        authorities(userEntity.
                                getRoles().
                                stream().
                                map(this::map).
                                toList()).
                        build();
    }

    private GrantedAuthority map(UserRole userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole.
                        getName().name());
    }

}
