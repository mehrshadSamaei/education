package com.example.educationalinstitutions.config;

import com.example.educationalinstitutions.domain.Student;
import com.example.educationalinstitutions.domain.Teacher;
import com.example.educationalinstitutions.mapper.StudentMapper;
import com.example.educationalinstitutions.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(2)
@Qualifier("Student")
public class StudentDetailService implements UserDetailsService {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        var userDto =  studentService.findByUsername(username);

        Student user = studentMapper.convertTToE(userDto);


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
