package com.example.educationalinstitutions.service.impl;

import com.example.educationalinstitutions.base.BaseServiceImpl;
import com.example.educationalinstitutions.domain.Student;
import com.example.educationalinstitutions.dto.StudentDto;
import com.example.educationalinstitutions.dto.search.StudentSearch;
import com.example.educationalinstitutions.mapper.StudentMapper;
import com.example.educationalinstitutions.repository.StudentRepository;
import com.example.educationalinstitutions.service.StudentService;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl extends BaseServiceImpl<
        StudentDto, Student, StudentMapper, Long, StudentRepository> implements StudentService {

    public StudentServiceImpl(StudentRepository repository, StudentMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public List<StudentDto> findAllAdvanceSearch(StudentSearch studentSearch) {
        repository.findAll(
                (root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    setFirstNameInPredicate(criteriaBuilder, root, predicates, studentSearch.getFirstName());
                    setLastNameInPredicate(criteriaBuilder, root, predicates, studentSearch.getLastName());
                    setUsernameInPredicate(criteriaBuilder, root, predicates, studentSearch.getUsername());
                    setEmailInPredicate(criteriaBuilder, root, predicates, studentSearch.getEmail());
                    setMobileNumInPredicate(criteriaBuilder, root, predicates, studentSearch.getMobileNum());
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }
        );
        return null;
    }

    private void setMobileNumInPredicate(CriteriaBuilder criteriaBuilder, Root<Student> root, List<Predicate> predicates, String mobileNum) {
        if (mobileNum != null) {
            predicates.add(criteriaBuilder.like(root.get("mobileNum"), "%" + mobileNum + "%"));
        }
    }

    private void setEmailInPredicate(CriteriaBuilder criteriaBuilder, Root<Student> root, List<Predicate> predicates, String email) {
        if (email != null) {
            predicates.add(criteriaBuilder.like(root.get("email"), "%" + email + "%"));
        }

    }

    private void setUsernameInPredicate(CriteriaBuilder criteriaBuilder, Root<Student> root, List<Predicate> predicates, String username) {
        if (username != null) {
            predicates.add(criteriaBuilder.like(root.get("username"), "%" + username + "%"));
        }

    }

    private void setLastNameInPredicate(CriteriaBuilder criteriaBuilder, Root<Student> root, List<Predicate> predicates, String lastName) {
        if (lastName != null) {
            predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%"));
        }
    }

    private void setFirstNameInPredicate(CriteriaBuilder criteriaBuilder, Root<Student> root, List<Predicate> predicates, String firstName) {
        if (firstName != null) {
            predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%"));
        }
    }
}
