package com.example.educationalinstitutions.service.impl;

import com.example.educationalinstitutions.base.BaseServiceImpl;
import com.example.educationalinstitutions.domain.Course;
import com.example.educationalinstitutions.domain.Student;
import com.example.educationalinstitutions.domain.Teacher;
import com.example.educationalinstitutions.dto.CourseDto;
import com.example.educationalinstitutions.dto.StudentDto;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.dto.search.CourseSearch;
import com.example.educationalinstitutions.mapper.CourseMapper;
import com.example.educationalinstitutions.mapper.StudentMapper;
import com.example.educationalinstitutions.mapper.TeacherMapper;
import com.example.educationalinstitutions.repository.CourseRepository;
import com.example.educationalinstitutions.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class CourseServiceImpl extends BaseServiceImpl<
        CourseDto, Course, CourseMapper, Long, CourseRepository> implements CourseService {


    public CourseServiceImpl(CourseRepository repository, CourseMapper mapper, TeacherMapper teacherMapper, StudentMapper studentMapper) {
        super(repository, mapper);
        this.teacherMapper = teacherMapper;
        this.studentMapper = studentMapper;
    }

    private final TeacherMapper teacherMapper;
    private final StudentMapper studentMapper;
    @Override
    public List<CourseDto> findAllAdvanceSearch(CourseSearch courseSearch) {
        List<Course> courseList = repository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            setTitleInPredicate(criteriaBuilder, root, predicates, courseSearch.getTitle());
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
        return mapper.convertListEToListT(courseList);
    }

    @Override
    public TeacherDto findTeacherByTitleSpecialCourse(String title) {
        Teacher teacherEntity = repository.findTeacherByTitleSpecialCourse(title);
        return teacherMapper.convertEToT(teacherEntity);
    }

    @Override
    public List<StudentDto> findAllStudentsByTitleSpecialCourse(String title) {
        List<Student> studentsEntity = repository.findAllStudentByTitleSpecialCourse(title);
        return studentMapper.convertListEToListT(studentsEntity);
    }

    private void setTitleInPredicate(CriteriaBuilder criteriaBuilder, Root<Course> root, List<Predicate> predicates, String title) {
        if (title != null) {
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + title + "%"));
        }
    }
}
