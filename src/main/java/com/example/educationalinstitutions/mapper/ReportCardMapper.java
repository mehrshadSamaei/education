package com.example.educationalinstitutions.mapper;

import com.example.educationalinstitutions.base.BaseMapper;
import com.example.educationalinstitutions.domain.ReportCard;
import com.example.educationalinstitutions.dto.ReportCardDto;
import org.mapstruct.Mapper;

@Mapper
public interface ReportCardMapper extends BaseMapper<ReportCardDto , ReportCard, Long> {
}
