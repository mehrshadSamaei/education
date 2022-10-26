package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.dto.StudentDto;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.service.StudentService;
import com.example.educationalinstitutions.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StudentResource {
    @Autowired
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<StudentDto> findAdminById(@RequestParam Long id){
        return ResponseEntity.ok(
                studentService.findById(id)
        );
    }
    @PostMapping
    public ResponseEntity<StudentDto> createAdmin(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(
                studentService.saveOrUpdate(studentDto)
        );
    }
    @PutMapping
    public ResponseEntity<StudentDto> updateAdmin(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(
                studentService.saveOrUpdate(studentDto)
        );
    }
    @DeleteMapping
    public void delete(@RequestBody StudentDto studentDto){
        Long id = studentDto.getId();
        studentService.deleteById(id);
    }
}
