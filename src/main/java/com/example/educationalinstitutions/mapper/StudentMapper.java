package com.example.educationalinstitutions.mapper;

import com.example.educationalinstitutions.base.BaseMapper;
import com.example.educationalinstitutions.domain.Student;
import com.example.educationalinstitutions.dto.StudentDto;
import org.mapstruct.Mapper;

import java.util.UUID;
@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMapper<StudentDto , Student , Long> {
}
