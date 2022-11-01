package com.example.educationalinstitutions.repository;

import com.example.educationalinstitutions.base.BaseRepository;
import com.example.educationalinstitutions.domain.Course;
import com.example.educationalinstitutions.domain.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends BaseRepository<Teacher , Long> {
    @Override
    Page<Teacher> findAll(Specification<Teacher> spec, Pageable pageable);
    Teacher findByUsername(String username);
    Teacher findByUsernameAndPassword(String username , String password);
    @Query(value = "select t.courses from Teacher t where t.username = :username")
    List<Course> findAllCoursesByTeacherUsername(String username);
//    @Query(value = "select t from Teacher t where t.courses = :courses")
//    Teacher findAllSpecialCourses(@Param("courses") Course courses);
}
