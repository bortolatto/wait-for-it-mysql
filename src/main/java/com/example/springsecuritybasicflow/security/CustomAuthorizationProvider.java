package com.example.springsecuritybasicflow.security;

import com.example.springsecuritybasicflow.entity.Algorithm;
import com.example.springsecuritybasicflow.entity.User;
import com.example.springsecuritybasicflow.service.JpaUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomAuthorizationProvider implements AuthenticationProvider {

    private final JpaUserDetailsService jpaUserDetailsService;
    private final PasswordEncoder bcryptPasswordEncoder;
    private final SCryptPasswordEncoder sCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDecorator userSecurity = jpaUserDetailsService.loadUserByUsername(username);
        User userDb = userSecurity.getUser();

        if (userDb.getAlgorithm().equals(Algorithm.BCRYPT)) {
            return checkPassword(password, bcryptPasswordEncoder, userSecurity);
        } else {
            return checkPassword(password, sCryptPasswordEncoder, userSecurity);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

    private Authentication checkPassword(String rawPassword, PasswordEncoder passwordEncoder, UserDecorator user) {
        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }
}
