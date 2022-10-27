package com.example.educationalinstitutions.domain;

import com.example.educationalinstitutions.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "student")
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Student extends User {
    @ManyToMany
    private Set<Role> roles = new HashSet<>();

}
