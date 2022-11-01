package com.example.educationalinstitutions.mapper;

import com.example.educationalinstitutions.base.BaseMapper;
import com.example.educationalinstitutions.domain.Exams;
import com.example.educationalinstitutions.dto.ExamsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamsMapper extends BaseMapper<ExamsDto, Exams, Long> {
}
