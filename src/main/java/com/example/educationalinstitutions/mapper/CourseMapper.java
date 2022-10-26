package com.example.educationalinstitutions.mapper;

import com.example.educationalinstitutions.base.BaseMapper;
import com.example.educationalinstitutions.domain.Course;
import com.example.educationalinstitutions.dto.CourseDto;
import org.mapstruct.Mapper;

import java.util.UUID;
@Mapper(componentModel = "spring")
public interface CourseMapper extends BaseMapper<CourseDto , Course, Long> {
}
