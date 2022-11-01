package com.example.educationalinstitutions.service.impl;

import com.example.educationalinstitutions.base.BaseServiceImpl;
import com.example.educationalinstitutions.domain.Exams;
import com.example.educationalinstitutions.dto.ExamsDto;
import com.example.educationalinstitutions.exceptions.NotFountEntity;
import com.example.educationalinstitutions.mapper.ExamsMapper;
import com.example.educationalinstitutions.repository.ExamsRepository;
import com.example.educationalinstitutions.service.ExamsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ExamsServiceImpl extends BaseServiceImpl<
        ExamsDto , Exams , ExamsMapper , Long , ExamsRepository> implements ExamsService {

    public ExamsServiceImpl(ExamsRepository repository, ExamsMapper mapper, ExamsRepository examsRepository, ExamsMapper examsMapper) {
        super(repository, mapper);
    }

//    public ExamsServiceImpl(ExamsRepository repository, ExamsMapper mapper, ExamsRepository examsRepository, ExamsMapper examsMapper) {
//        super(repository, mapper);
//        this.examsRepository = examsRepository;
//        this.examsMapper = examsMapper;
//    }

    @Override
    public ExamsDto findByTitle(String title) {
        Exams exam = repository.findByTitle(title);
        if (exam == null)
            throw new NotFountEntity("nothing exam");
        return mapper.convertEToT(exam);
    }
}
