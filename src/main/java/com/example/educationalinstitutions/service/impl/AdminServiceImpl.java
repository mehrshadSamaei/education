package com.example.educationalinstitutions.service.impl;

import com.example.educationalinstitutions.base.BaseRepository;
import com.example.educationalinstitutions.base.BaseService;
import com.example.educationalinstitutions.base.BaseServiceImpl;
import com.example.educationalinstitutions.domain.Admin;
import com.example.educationalinstitutions.dto.AdminDto;
import com.example.educationalinstitutions.dto.UserDto;
import com.example.educationalinstitutions.dto.search.AdminSearch;
import com.example.educationalinstitutions.mapper.AdminMapper;
import com.example.educationalinstitutions.repository.AdminRepository;
import com.example.educationalinstitutions.service.AdminService;
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
public class AdminServiceImpl extends BaseServiceImpl<
        AdminDto, Admin, AdminMapper, Long, AdminRepository> implements AdminService {
    @Autowired
    public AdminServiceImpl(AdminRepository repository, AdminMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public List<AdminDto> findAllAdvanceSearch(AdminSearch adminSearch) {
        List<Admin> adminList = repository.findAll((root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    setFirstNameInPredicate(criteriaBuilder, root, predicates, adminSearch.getFirstName());
                    setLastNameInPredicate(criteriaBuilder, root, predicates, adminSearch.getLastName());
                    setUsernameInPredicate(criteriaBuilder, root, predicates, adminSearch.getUsername());
                    setMobileNumInPredicate(criteriaBuilder, root, predicates, adminSearch.getMobileNum());
                    setEmailAddressInPredicate(criteriaBuilder, root, predicates, adminSearch.getEmail());
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }

        );

        return mapper.convertListEToListT(adminList);
    }

    @Override
    public AdminDto findByUsername(String username) {
        Admin adminsByUsername = repository.findAdminsByUsername(username);
        AdminDto adminDto = mapper.convertEToT(adminsByUsername);
        return adminDto;
    }

    private void setEmailAddressInPredicate(CriteriaBuilder criteriaBuilder, Root<Admin> root, List<Predicate> predicates, String email) {
        if (email != null) {
            predicates.add(
                    criteriaBuilder.like(root.get("email"), "%" + email + "%")
            );
        }
    }

    private void setMobileNumInPredicate(CriteriaBuilder criteriaBuilder, Root<Admin> root, List<Predicate> predicates, String mobileNum) {
        if (mobileNum != null) {
            predicates.add(
                    criteriaBuilder.like(root.get("mobileNum"), "%" + mobileNum + "%")
            );
        }
    }

    private void setUsernameInPredicate(CriteriaBuilder criteriaBuilder, Root<Admin> root, List<Predicate> predicates, String username) {
        if (username != null) {
            predicates.add(
                    criteriaBuilder.like(root.get("username"), "%" + username + "%")
            );
        }
    }

    private void setLastNameInPredicate(CriteriaBuilder criteriaBuilder, Root<Admin> root, List<Predicate> predicates, String lastName) {
        if (lastName != null) {
            predicates.add(
                    criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%")
            );
        }
    }

    private void setFirstNameInPredicate(CriteriaBuilder criteriaBuilder, Root<Admin> root, List<Predicate> predicates, String firstName) {
        if (firstName != null) {

            predicates.add(
                    criteriaBuilder.like(
                            root.get("firstName"),
                            "%" + firstName + "%"
                    )
            );
        }
    }
}
