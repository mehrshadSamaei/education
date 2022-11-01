package com.example.educationalinstitutions.repository;

import com.example.educationalinstitutions.base.BaseRepository;
import com.example.educationalinstitutions.domain.Course;
import com.example.educationalinstitutions.domain.Student;
import com.example.educationalinstitutions.domain.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends BaseRepository<Course , Long> {
    @Override
    Page<Course> findAll(Specification<Course> spec, Pageable pageable);
    @Query("select c.teacher from Course c where c.title = :title")
    Teacher findTeacherByTitleSpecialCourse(@Param("title") String title);
    @Query("select c.students from Course c where c.title = :title")
    List<Student> findAllStudentByTitleSpecialCourse(@Param("title") String title);
}
