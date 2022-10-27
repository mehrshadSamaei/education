package com.example.educationalinstitutions.service;

import com.example.educationalinstitutions.base.BaseService;
import com.example.educationalinstitutions.dto.AdminDto;
import com.example.educationalinstitutions.dto.UserDto;
import com.example.educationalinstitutions.dto.search.AdminSearch;

import java.util.List;
import java.util.UUID;

public interface AdminService extends BaseService<AdminDto , Long> {
    List<AdminDto> findAllAdvanceSearch(AdminSearch adminSearch);

    AdminDto findByUsername(String username);

    AdminDto findByUsernameAndPassword(String username , String password);
}
