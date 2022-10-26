package com.example.educationalinstitutions.domain;

import com.example.educationalinstitutions.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "teacher")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher extends BaseEntity<Long> {
    @Column(name = "Specialty")
    private String Specialty;
    @Column(name = "work_experience")
    private Integer workExperience;
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;
}
