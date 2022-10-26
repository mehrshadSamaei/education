package com.example.educationalinstitutions.repository;

import com.example.educationalinstitutions.base.BaseRepository;
import com.example.educationalinstitutions.domain.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public interface AdminRepository extends BaseRepository<Admin , Long> {
    @Override
    Page<Admin> findAll(Specification<Admin> spec, Pageable pageable);
}
