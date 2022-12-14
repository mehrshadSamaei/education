package com.example.educationalinstitutions.domain;

import com.example.educationalinstitutions.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "student")
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Student extends User {
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy = "student")
    private List<ReportCard> reportCards;
    @ManyToOne
    private Course course;

}
