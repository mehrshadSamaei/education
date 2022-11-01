package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.domain.Wait;
import com.example.educationalinstitutions.dto.AdminDto;
import com.example.educationalinstitutions.dto.StudentDto;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.exceptions.NotFountEntity;
import com.example.educationalinstitutions.service.AdminService;
import com.example.educationalinstitutions.service.StudentService;
import com.example.educationalinstitutions.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginResource {
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/panel-admin")
    public ResponseEntity<AdminDto> loginAdmin(@RequestBody String username, String password) {
        AdminDto adminDto = adminService.findByUsernameAndPassword(username, password);
        if (adminDto == null) {
            throw new NotFountEntity("username or password is wrong!!!");
        } else {
            return ResponseEntity.ok(
                    adminDto
            );
        }
    }

    @PostMapping("/panel-teacher")
    public ResponseEntity<TeacherDto> loginTeacher(@RequestBody String username, String password) {
        TeacherDto teacherDto = teacherService.findByUsernameAndPassword(username, password);
        if (teacherDto == null) {
            throw new NotFountEntity("username or password is wrong!!!");
        } else if (teacherDto.getStatus().equals(Wait.confirmation)) {
            return ResponseEntity.ok(
                    teacherDto
            );
        } else {
            return null;
        }
    }

    @PostMapping("/panel-student")
    public ResponseEntity<StudentDto> loginStudent(@RequestBody String username, String password) {
        StudentDto studentDto = studentService.findByUsernameAndPassword(username, password);
        if (studentDto == null) {
            throw new NotFountEntity("username or password is wrong!!!");
        } else if (studentDto.getStatus().equals(Wait.confirmation)) {
            return ResponseEntity.ok(
                    studentDto
            );
        } else {
            return null;
        }
    }
}
