package com.example.educationalinstitutions.repository;

import com.example.educationalinstitutions.base.BaseRepository;
import com.example.educationalinstitutions.domain.Exams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamsRepository extends BaseRepository<Exams , Long> {
    Exams findByTitle(String title);

}
