package com.example.educationalinstitutions.mapper;

import com.example.educationalinstitutions.base.BaseMapper;
import com.example.educationalinstitutions.domain.Teacher;
import com.example.educationalinstitutions.dto.TeacherDto;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends BaseMapper<TeacherDto , Teacher , Long> {

}
