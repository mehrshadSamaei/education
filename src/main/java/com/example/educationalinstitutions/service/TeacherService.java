package com.example.educationalinstitutions.service;

import com.example.educationalinstitutions.base.BaseService;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.dto.search.TeacherSearch;

import java.util.List;
import java.util.UUID;

public interface TeacherService extends BaseService<TeacherDto , Long> {
    List<TeacherDto> findAllAdvanceSearch(TeacherSearch teacherSearch);
}
