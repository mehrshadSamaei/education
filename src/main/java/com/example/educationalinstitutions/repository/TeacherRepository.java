package com.example.educationalinstitutions.repository;

import com.example.educationalinstitutions.base.BaseRepository;
import com.example.educationalinstitutions.domain.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public interface TeacherRepository extends BaseRepository<Teacher , Long> {
    @Override
    Page<Teacher> findAll(Specification<Teacher> spec, Pageable pageable);
    Teacher findByUsername(String username);
    Teacher findByUsernameAndPassword(String username , String password);
}
