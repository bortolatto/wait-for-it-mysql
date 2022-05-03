package com.example.springsecuritybasicflow.service;

import com.example.springsecuritybasicflow.entity.User;
import com.example.springsecuritybasicflow.model.UserRepository;
import com.example.springsecuritybasicflow.security.UserDecorator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDecorator loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
            new IllegalArgumentException(String.format("Username [%s] not found", username)));

        return new UserDecorator(user);
    }
}
