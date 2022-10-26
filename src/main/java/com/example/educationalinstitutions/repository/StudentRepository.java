package com.example.educationalinstitutions.repository;

import com.example.educationalinstitutions.base.BaseRepository;
import com.example.educationalinstitutions.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public interface StudentRepository extends BaseRepository<Student , Long> {
    @Override
    Page<Student> findAll(Specification<Student> spec, Pageable pageable);
}
