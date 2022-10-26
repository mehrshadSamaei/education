package com.example.educationalinstitutions.repository;

import com.example.educationalinstitutions.base.BaseRepository;
import com.example.educationalinstitutions.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public interface CourseRepository extends BaseRepository<Course , Long> {
    @Override
    Page<Course> findAll(Specification<Course> spec, Pageable pageable);
}
