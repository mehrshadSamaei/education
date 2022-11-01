package com.example.educationalinstitutions.service.impl;

import com.example.educationalinstitutions.base.BaseServiceImpl;
import com.example.educationalinstitutions.domain.Course;
import com.example.educationalinstitutions.domain.Teacher;
import com.example.educationalinstitutions.dto.CourseDto;
import com.example.educationalinstitutions.dto.TeacherDto;
import com.example.educationalinstitutions.dto.search.TeacherSearch;
import com.example.educationalinstitutions.mapper.CourseMapper;
import com.example.educationalinstitutions.mapper.TeacherMapper;
import com.example.educationalinstitutions.repository.TeacherRepository;
import com.example.educationalinstitutions.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TeacherServiceImpl extends BaseServiceImpl<
        TeacherDto, Teacher, TeacherMapper, Long, TeacherRepository> implements TeacherService {

    public TeacherServiceImpl(TeacherRepository repository, TeacherMapper mapper) {
        super(repository, mapper);
    }
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<TeacherDto> findAllAdvanceSearch(TeacherSearch teacherSearch) {
        List<Teacher> teacherList = repository.findAll(
                (root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    setFirstNameInPredicate(criteriaBuilder, root, predicates, teacherSearch.getFirstName());
                    setLastNameInPredicate(criteriaBuilder, root, predicates, teacherSearch.getLastName());
                    setUsernameInPredicate(criteriaBuilder, root, predicates, teacherSearch.getUsername());
                    setMobileNumInPredicate(criteriaBuilder, root, predicates, teacherSearch.getMobileNum());
                    setEmailInPredicate(criteriaBuilder, root, predicates, teacherSearch.getEmail());
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }
        );
        return mapper.convertListEToListT(teacherList);
    }
    @Override
    public TeacherDto findByUsername(String username) {
        Teacher teacher = repository.findByUsername(username);
        return mapper.convertEToT(teacher);
    }

    @Override
    public TeacherDto findByUsernameAndPassword(String username, String password) {
        Teacher teacher = repository.findByUsernameAndPassword(username, password);
        return mapper.convertEToT(teacher);
    }

//    @Override
//    public TeacherDto findAllSpecialCourses(CourseDto courseDto) {
//        Course course = courseMapper.convertTToE(courseDto);
//        Teacher teacher = repository.findAllSpecialCourses(course);
//        TeacherDto teacherDto = mapper.convertEToT(teacher);
//        return teacherDto;
//    }

    private void setEmailInPredicate(CriteriaBuilder criteriaBuilder, Root<Teacher> root, List<Predicate> predicates, String email) {
        if (email != null) {
            predicates.add(criteriaBuilder.like(root.get("email"), "%" + email + "%"));
        }
    }

    private void setMobileNumInPredicate(CriteriaBuilder criteriaBuilder, Root<Teacher> root, List<Predicate> predicates, String mobileNum) {
        if (mobileNum != null) {
            predicates.add(criteriaBuilder.like(root.get("mobileNum"), "%" + mobileNum + "%"));
        }
    }

    private void setUsernameInPredicate(CriteriaBuilder criteriaBuilder, Root<Teacher> root, List<Predicate> predicates, String username) {
        if (username != null) {
            predicates.add(criteriaBuilder.like(root.get("username"), "%" + username + "%"));
        }
    }

    private void setLastNameInPredicate(CriteriaBuilder criteriaBuilder, Root<Teacher> root, List<Predicate> predicates, String lastName) {
        if (lastName != null) {
            predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%"));
        }
    }

    private void setFirstNameInPredicate(CriteriaBuilder criteriaBuilder, Root<Teacher> root, List<Predicate> predicates, String firstName) {
        if (firstName != null) {
            predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%"));
        }
    }
}
