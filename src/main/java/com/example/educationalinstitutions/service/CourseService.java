package com.example.educationalinstitutions.service;

import com.example.educationalinstitutions.base.BaseService;
import com.example.educationalinstitutions.domain.Course;
import com.example.educationalinstitutions.domain.Teacher;
import com.example.educationalinstitutions.dto.CourseDto;
import com.example.educationalinstitutions.dto.StudentDto;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.dto.search.CourseSearch;

import java.util.List;
import java.util.UUID;

public interface CourseService extends BaseService<CourseDto , Long> {
    List<CourseDto> findAllAdvanceSearch(CourseSearch courseSearch);
    TeacherDto findTeacherByTitleSpecialCourse(String title);
    List<StudentDto> findAllStudentsByTitleSpecialCourse(String title);
}
