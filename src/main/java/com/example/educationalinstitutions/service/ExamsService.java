package com.example.educationalinstitutions.service;

import com.example.educationalinstitutions.base.BaseService;
import com.example.educationalinstitutions.dto.ExamsDto;

public interface ExamsService extends BaseService<ExamsDto, Long> {
    ExamsDto findByTitle(String title);
}
