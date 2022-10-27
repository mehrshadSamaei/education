package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.domain.Wait;
import com.example.educationalinstitutions.dto.AdminDto;
import com.example.educationalinstitutions.dto.StudentDto;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.dto.search.AdminSearch;
import com.example.educationalinstitutions.exceptions.NotFountEntity;
import com.example.educationalinstitutions.service.AdminService;
import com.example.educationalinstitutions.service.StudentService;
import com.example.educationalinstitutions.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminResource {
    Long id;
    @Autowired
    private final AdminService adminService;
    @Autowired
    private final TeacherService teacherService;
    @Autowired
    private final StudentService studentService;

    @GetMapping("/login-admin")
    public void loginAdmin(@RequestParam String username, String password) {
        AdminDto adminDto = adminService.findByUsernameAndPassword(username, password);
        if (adminDto == null) {
            throw new NotFountEntity("username or password is wrong!!!");
        } else {
            listTeachers();
            listStudent();
            findIdNumTeachers(id);
            findIdNumStudents(id);
        }
    }
    @PutMapping("change-access-student")
    private ResponseEntity<StudentDto> findIdNumStudents(@RequestParam Long id) {
        StudentDto studentDto = studentService.findById(id);
        if (studentDto == null){
            throw new NotFountEntity("not found student");
        }
        studentDto.setStatus(Wait.confirmation.getConvertString());
        return ResponseEntity.ok(
                studentService.saveOrUpdate(studentDto)
        );
    }

    @PutMapping("change-access-teacher")
    private ResponseEntity<TeacherDto> findIdNumTeachers(@RequestParam Long id) {
        TeacherDto teacherDto = teacherService.findById(id);
        if (teacherDto.getId() == null){
            throw new NotFountEntity("not found teacher");
        }
        teacherDto.setStatus(Wait.confirmation.getConvertString());
        return ResponseEntity.ok(
                teacherService.saveOrUpdate(teacherDto)
        );
    }

    @GetMapping("/list-student-for-accept")
    private ResponseEntity<List<StudentDto>> listStudent() {
        return ResponseEntity.ok(studentService.findAll());
    }
    @GetMapping("/accected-teacher")
    private ResponseEntity<List<TeacherDto>> listTeachers() {
        return ResponseEntity.ok(
                teacherService.findAll()
        );
    }

    @GetMapping("/find-by-id-admin")
    public ResponseEntity<AdminDto> findAdminById(@RequestParam Long id) {
        return ResponseEntity.ok(
                adminService.findById(id)
        );
    }

    @GetMapping("/list-admin")
    public ResponseEntity<List<AdminDto>> listAllAdmins() {
        return ResponseEntity.ok(
                adminService.findAll()
        );
    }

    @PostMapping("/save-admin")
    public void createAdmin(@RequestBody @Valid AdminDto adminDto) {
        ResponseEntity.ok(
                adminService.saveOrUpdate(adminDto)
        );
    }

    @PutMapping("/update-admin")
    public ResponseEntity<AdminDto> updateAdmin(@RequestBody AdminDto adminDto) {
        return ResponseEntity.ok(
                adminService.saveOrUpdate(adminDto)
        );
    }

    @DeleteMapping("/delete-admin")
    public void delete(@RequestBody AdminDto adminDto) {
        Long id = adminDto.getId();
        adminService.deleteById(id);
    }

    @PostMapping("/search-admin")
    public ResponseEntity<List<AdminDto>> advanceSearch(@RequestBody AdminSearch adminSearch) {
        return ResponseEntity.ok(
                adminService.findAllAdvanceSearch(adminSearch)
        );
    }
}
