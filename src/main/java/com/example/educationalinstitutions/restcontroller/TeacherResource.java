package com.example.educationalinstitutions.restcontroller;
import com.example.educationalinstitutions.domain.Wait;
import com.example.educationalinstitutions.dto.AdminDto;
import com.example.educationalinstitutions.dto.CourseDto;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.dto.search.TeacherSearch;
import com.example.educationalinstitutions.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherResource {
    @Autowired
    private final TeacherService teacherService;

    @GetMapping("/find-by-id-teacher")
    public ResponseEntity<TeacherDto> findAdminById(@RequestParam Long id){
        return ResponseEntity.ok(
                teacherService.findById(id)
        );
    }
    @GetMapping("/list-Teachers")
    public ResponseEntity<List<TeacherDto>> findAllTeachers(){
        return ResponseEntity.ok(
                teacherService.findAll()
        );
    }
    @PostMapping("/save-teacher")
    public ResponseEntity<TeacherDto> createAdmin(@RequestBody @Valid TeacherDto teacherDto){
         return new ResponseEntity<>(
                 teacherService.saveOrUpdate(teacherDto) , HttpStatus.CREATED
         );
    }
    @PutMapping("/update-teacher")
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody TeacherDto teacherDto){
        return ResponseEntity.ok(
                teacherService.saveOrUpdate(teacherDto)
        );
    }
    @DeleteMapping("delete-teacher")
    public void delete(@RequestBody TeacherDto teacherDto){
        Long id = teacherDto.getId();
        teacherService.deleteById(id);
    }
    @PostMapping("/search-teacher")
    public ResponseEntity<List<TeacherDto>> advanceSearchTeacher(@RequestBody TeacherSearch teacherSearch){
        return ResponseEntity.ok(
                teacherService.findAllAdvanceSearch(teacherSearch)
        );
    }
    @PatchMapping
    public ResponseEntity<TeacherDto> changeAccessTeacher(@RequestBody TeacherDto teacherDto){
        teacherDto.setStatus(Wait.confirmation.getConvertString());
        return ResponseEntity.ok(
                teacherService.saveOrUpdate(teacherDto)
        );
    }
//    @GetMapping("/list-teachers-special-course")
//    public ResponseEntity<TeacherDto> getAllTeachersSpecialCourse(@RequestParam CourseDto courseDto){
//        return ResponseEntity.ok(
//                teacherService.findAllSpecialCourses(courseDto)
//        );
//    }
    @GetMapping
    public ResponseEntity<List<CourseDto>> findAllCourseWithUsername(@RequestParam String username){
       return ResponseEntity.ok(
             teacherService.findAllCoursesByTeacherUsername(username)
        );
    }
}
