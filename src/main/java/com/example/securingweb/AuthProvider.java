package com.example.securingweb;

import com.example.entity.Attempts;
import com.example.repository.AttemptsRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthProvider implements AuthenticationProvider {

    private UserDetailsService securityUserDetailService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AttemptsRepository attemptsRepository;

    public AuthProvider(UserDetailsService securityUserDetailService) {
        this.securityUserDetailService = securityUserDetailService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("AuthProvider: authenticate");
        String username = authentication.getName();

        Optional<Attempts> attemptsOptional = attemptsRepository.findByUsername(username);

        if (attemptsOptional.isPresent()) {
            Attempts attempts = attemptsOptional.get();
            attempts.setAttempts(0);

            attemptsRepository.save(attempts);
        }

        return authentication;
    }



    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
