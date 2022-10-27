package com.example.educationalinstitutions.domain;

import com.example.educationalinstitutions.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "report_card")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportCard extends BaseEntity<Long> {
    @Column(name = "grade")
    private Double grade;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;
}
