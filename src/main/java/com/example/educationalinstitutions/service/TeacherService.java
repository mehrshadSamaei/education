package com.example.educationalinstitutions.service;

import com.example.educationalinstitutions.base.BaseService;
import com.example.educationalinstitutions.domain.Course;
import com.example.educationalinstitutions.dto.CourseDto;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.dto.search.TeacherSearch;

import java.util.List;
import java.util.UUID;

public interface TeacherService extends BaseService<TeacherDto, Long> {
    List<TeacherDto> findAllAdvanceSearch(TeacherSearch teacherSearch);

    TeacherDto findByUsername(String username);

    TeacherDto findByUsernameAndPassword(String username, String password);

    //    TeacherDto findAllSpecialCourses(CourseDto courseDto);
    List<CourseDto> findAllCoursesByTeacherUsername(String username);
}
