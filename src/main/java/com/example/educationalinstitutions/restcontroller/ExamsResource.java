package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.domain.Teacher;
import com.example.educationalinstitutions.dto.ExamsDto;
import com.example.educationalinstitutions.exceptions.NotFountEntity;
import com.example.educationalinstitutions.service.CourseService;
import com.example.educationalinstitutions.service.ExamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamsResource {
    private final ExamsService examsService;
    private final CourseService courseService;
    @GetMapping("/find-by-id-exam")
    public ResponseEntity<ExamsDto> findExamById(@RequestParam Long id){
        ExamsDto examDto = examsService.findById(id);
        return ResponseEntity.ok(
                examDto
        );
    }
    @GetMapping("/find-by-title")
    public ResponseEntity<ExamsDto> findByTitle(@RequestParam String title){
       return ResponseEntity.ok(
                examsService.findByTitle(title)
        );
    }
    @GetMapping("find-all-exams")
    public ResponseEntity<List<ExamsDto>> findAllExams(){
        return ResponseEntity.ok(
                examsService.findAll()
        );
    }
    @PostMapping("/save-exam")
    public ResponseEntity<ExamsDto> save(@RequestBody ExamsDto examsDto){
        return new ResponseEntity<>(
                examsService.saveOrUpdate(examsDto), HttpStatus.CREATED
        );
    }
    @PutMapping("/update-exam")
    public ResponseEntity<ExamsDto> update(@RequestBody ExamsDto examsDto){
        return ResponseEntity.ok(
                examsService.saveOrUpdate(examsDto)
        );
    }
    @DeleteMapping("/delete-exam")
    public void deleteExam(@RequestBody ExamsDto examsDto){
        if (examsDto.getId() == null)
            throw new NotFountEntity("exam not found");
        examsService.deleteById(examsDto.getId());
    }
    @GetMapping("/list-exams-username-teacher")
    public ResponseEntity<List<ExamsDto>> findAllExamsByTeacherUsername(@RequestParam String username){
        List<ExamsDto> allListExams = courseService.findAllListExams(username);
        return ResponseEntity.ok(
                allListExams
        );
    }
}
