package com.example.educationalinstitutions.service;

import com.example.educationalinstitutions.base.BaseService;
import com.example.educationalinstitutions.dto.StudentDto;
import com.example.educationalinstitutions.dto.search.StudentSearch;

import java.util.List;
import java.util.UUID;

public interface StudentService extends BaseService<StudentDto , Long> {
    List<StudentDto> findAllAdvanceSearch(StudentSearch studentSearch);
    StudentDto findByUsername(String username);
}
