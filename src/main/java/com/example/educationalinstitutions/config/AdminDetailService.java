package com.example.educationalinstitutions.config;

import com.example.educationalinstitutions.domain.Admin;
import com.example.educationalinstitutions.mapper.AdminMapper;
import com.example.educationalinstitutions.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(1)
@Qualifier("Admin")
@Primary
public class AdminDetailService implements UserDetailsService {

    private final AdminService adminService;
    private final AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        var userDto =  adminService.findByUsername(username);

        Admin user = adminMapper.convertTToE(userDto);

        if (user == null){
            throw new UsernameNotFoundException("user not found");
        }
        return org.springframework.security.core.userdetails.User.withUsername(username)
                .password(user.getPassword())
                .authorities(
                        user.getRoles().stream()
                                .map(role -> "ROLE_.".concat(role.getName()))
                                .distinct().toArray(String[]::new)
                ).build();
    }
}
