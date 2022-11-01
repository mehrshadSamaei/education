package com.example.educationalinstitutions.dto;

import com.example.educationalinstitutions.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class AdminDto extends UserDto {
private Set<Role> roles = new HashSet<>();

}
