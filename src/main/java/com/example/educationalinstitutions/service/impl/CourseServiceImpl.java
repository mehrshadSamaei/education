package com.example.educationalinstitutions.service.impl;

import com.example.educationalinstitutions.base.BaseServiceImpl;
import com.example.educationalinstitutions.domain.Course;
import com.example.educationalinstitutions.dto.CourseDto;
import com.example.educationalinstitutions.dto.search.CourseSearch;
import com.example.educationalinstitutions.mapper.CourseMapper;
import com.example.educationalinstitutions.repository.CourseRepository;
import com.example.educationalinstitutions.service.CourseService;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl extends BaseServiceImpl<
        CourseDto, Course, CourseMapper, Long, CourseRepository> implements CourseService {
    public CourseServiceImpl(CourseRepository repository, CourseMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public List<CourseDto> findAllAdvanceSearch(CourseSearch courseSearch) {
        repository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            setTitleInPredicate(criteriaBuilder, root, predicates, courseSearch.getTitle());
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
        return null;
    }

    private void setTitleInPredicate(CriteriaBuilder criteriaBuilder, Root<Course> root, List<Predicate> predicates, String title) {
        if (title != null) {
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + title + "%"));
        }
    }
}
