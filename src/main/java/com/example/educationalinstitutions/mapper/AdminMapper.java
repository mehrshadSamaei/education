package com.example.educationalinstitutions.mapper;

import com.example.educationalinstitutions.base.BaseMapper;
import com.example.educationalinstitutions.domain.Admin;
import com.example.educationalinstitutions.dto.AdminDto;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AdminMapper extends BaseMapper<AdminDto , Admin , Long> {

}
