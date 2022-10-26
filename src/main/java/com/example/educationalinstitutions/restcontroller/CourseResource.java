package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.dto.CourseDto;
import com.example.educationalinstitutions.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CourseResource {
    @Autowired
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<CourseDto> findAdminById(@RequestParam Long id){
        return ResponseEntity.ok(
                courseService.findById(id)
        );
    }
    @PostMapping
    public ResponseEntity<CourseDto> createAdmin(@RequestBody CourseDto courseDto){
        return ResponseEntity.ok(
                courseService.saveOrUpdate(courseDto)
        );
    }
    @PutMapping
    public ResponseEntity<CourseDto> updateAdmin(@RequestBody CourseDto courseDto){
        return ResponseEntity.ok(
                courseService.saveOrUpdate(courseDto)
        );
    }
    @DeleteMapping
    public void delete(@RequestBody CourseDto courseDto){
        Long id = courseDto.getId();
        courseService.deleteById(id);
    }
}
