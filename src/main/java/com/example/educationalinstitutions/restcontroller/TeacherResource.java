package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.dto.AdminDto;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TeacherResource {
    @Autowired
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<TeacherDto> findAdminById(@RequestParam Long id){
        return ResponseEntity.ok(
                teacherService.findById(id)
        );
    }
    @PostMapping
    public ResponseEntity<TeacherDto> createAdmin(@RequestBody TeacherDto teacherDto){
        return ResponseEntity.ok(
                teacherService.saveOrUpdate(teacherDto)
        );
    }
    @PutMapping
    public ResponseEntity<TeacherDto> updateAdmin(@RequestBody TeacherDto teacherDto){
        return ResponseEntity.ok(
                teacherService.saveOrUpdate(teacherDto)
        );
    }
    @DeleteMapping
    public void delete(@RequestBody TeacherDto teacherDto){
        Long id = teacherDto.getId();
        teacherService.deleteById(id);
    }
}
