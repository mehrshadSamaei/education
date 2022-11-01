package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.domain.Wait;
import com.example.educationalinstitutions.dto.CourseDto;
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

    @GetMapping("login-student")
    public ResponseEntity<StudentDto> loginStudent(@RequestParam String username ,@RequestParam String password){
        StudentDto studentDto = studentService.findByUsernameAndPassword(username, password);
        return ResponseEntity.ok(studentDto);
    }


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
    @DeleteMapping("/delete-student")
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
    @PatchMapping("/change-access")
    public ResponseEntity<StudentDto> changeStatus(@RequestBody StudentDto studentDto){
        studentDto.setStatus(Wait.confirmation.getConvertString());
        return ResponseEntity.ok(
                studentService.saveOrUpdate(studentDto)
        );
    }
//    @GetMapping("/list-student-special-courses")
//    public ResponseEntity<List<StudentDto>> getAllStudentSpecialCourses(@RequestParam CourseDto courseDto){
//        return ResponseEntity.ok(
//                studentService.findAllSpecialCourses(courseDto)
//        );
//    }
}
