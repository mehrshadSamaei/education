package com.example.educationalinstitutions.domain;

import com.example.educationalinstitutions.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "teacher")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Teacher extends User {
    @Column(name = "Specialty")
    private String Specialty;
    @Column(name = "work_experience")
    private Integer workExperience;
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
