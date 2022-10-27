package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.dto.CourseDto;
import com.example.educationalinstitutions.dto.search.CourseSearch;
import com.example.educationalinstitutions.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseResource {
    @Autowired
    private final CourseService courseService;

    @GetMapping("/find-by-id-course")
    public ResponseEntity<CourseDto> findAdminById(@RequestParam Long id){
        return ResponseEntity.ok(
                courseService.findById(id)
        );
    }
    @GetMapping("/list-courses")
    public ResponseEntity<List<CourseDto>> listCourses(){
        return ResponseEntity.ok(
                courseService.findAll()
        );
    }
    @PostMapping("/save-course")
    public void createAdmin(@RequestBody CourseDto courseDto){
         ResponseEntity.ok(
                courseService.saveOrUpdate(courseDto)
        );
    }
    @PutMapping("/update-course")
    public ResponseEntity<CourseDto> updateAdmin(@RequestBody CourseDto courseDto){
        return ResponseEntity.ok(
                courseService.saveOrUpdate(courseDto)
        );
    }
    @DeleteMapping("delete-course")
    public void delete(@RequestBody CourseDto courseDto){
        Long id = courseDto.getId();
        courseService.deleteById(id);
    }
    @PostMapping("/search-course")
    public ResponseEntity<List<CourseDto>> advanceSearchCourse(@RequestBody CourseSearch courseSearch){
        return ResponseEntity.ok(
                courseService.findAllAdvanceSearch(courseSearch)
        );
    }
}
