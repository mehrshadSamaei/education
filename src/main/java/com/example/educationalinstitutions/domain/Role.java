package com.example.educationalinstitutions.domain;

import com.example.educationalinstitutions.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity<Long> {
    private String role;
    private String username;

}
