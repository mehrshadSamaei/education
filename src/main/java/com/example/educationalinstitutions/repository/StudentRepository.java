package com.example.educationalinstitutions.repository;

import com.example.educationalinstitutions.base.BaseRepository;
import com.example.educationalinstitutions.domain.Course;
import com.example.educationalinstitutions.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student, Long> {
    @Override
    Page<Student> findAll(Specification<Student> spec, Pageable pageable);

    Student findByUsername(String username);

    Student findByUsernameAndPassword(String username, String password);
//    @Query(value = "select s from Student s where s.course = :course")
//    List<Student> findAllSpecialCourses(@Param("course") Course course);
}
