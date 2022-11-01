package com.example.educationalinstitutions.domain;

import com.example.educationalinstitutions.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
//@Documented
public class Exams extends BaseEntity<Long> {
    private String title;
    private String description;
    private Time time;
    @ManyToOne
    private Course course;
}
