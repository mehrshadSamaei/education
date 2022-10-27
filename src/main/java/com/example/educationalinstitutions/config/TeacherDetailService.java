package com.example.educationalinstitutions.config;

import com.example.educationalinstitutions.domain.Admin;
import com.example.educationalinstitutions.domain.Teacher;
import com.example.educationalinstitutions.mapper.TeacherMapper;
import com.example.educationalinstitutions.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(3)
@Qualifier("Teacher")
public class TeacherDetailService implements UserDetailsService {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        var userDto =  teacherService.findByUsername(username);

        Teacher user = teacherMapper.convertTToE(userDto);

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
