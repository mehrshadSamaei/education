package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.dto.StudentDto;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.dto.search.StudentSearch;
import com.example.educationalinstitutions.service.StudentService;
import com.example.educationalinstitutions.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentResource {
    @Autowired
    private final StudentService studentService;

    @GetMapping("/find-by-id-student")
    public ResponseEntity<StudentDto> findAdminById(@RequestParam Long id){
        return ResponseEntity.ok(
                studentService.findById(id)
        );
    }
    @GetMapping("/list-students")
    public ResponseEntity<List<StudentDto>> findAllStudents(){
        return ResponseEntity.ok(
                studentService.findAll()
        );
    }
    @PostMapping("/save-admin")
    public void createAdmin(@RequestBody @Valid StudentDto studentDto){
         ResponseEntity.ok(
                studentService.saveOrUpdate(studentDto)
        );
    }
    @PutMapping("/update-admin")
    public ResponseEntity<StudentDto> updateAdmin(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(
                studentService.saveOrUpdate(studentDto)
        );
    }
    @DeleteMapping("/delete-admin")
    public void delete(@RequestBody StudentDto studentDto){
        Long id = studentDto.getId();
        studentService.deleteById(id);
    }
    @PostMapping("/search-student")
    public ResponseEntity<List<StudentDto>> advanceStudentSearch(@RequestBody StudentSearch studentSearch){
         return ResponseEntity.ok(
                studentService.findAllAdvanceSearch(studentSearch)
        );
    }
}
