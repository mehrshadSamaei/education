package com.example.educationalinstitutions.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
//@RequiredArgsConstructor
public class MyAuthenticationProvider implements AuthenticationProvider {
//    @Autowired
    protected final UserDetailsService userDetailsService;
//    @Autowired
    protected final PasswordEncoder passwordEncoder;

    public MyAuthenticationProvider(@Qualifier(value = "AdminDetailService")UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        passwordEncoder.matches(password, userDetails.getPassword())
        if (password.equals(userDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(
                    username , password , userDetails.getAuthorities()
            );
        }else {
            throw new BadCredentialsException("wrong username and password!!!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
