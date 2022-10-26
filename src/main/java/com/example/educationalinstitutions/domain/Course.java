package com.example.educationalinstitutions.domain;

import com.example.educationalinstitutions.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.util.UUID;
@Entity
@Table(name = "coursess")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course extends BaseEntity<Long> {
    @Column(name = "title" )
    private String title;
    @Column(name = "start_course_day")
    private Date startCourseDay;
    @Column(name = "endOf_course_day")
    private Date endOfCourseDay;
    @ManyToOne
    private Teacher teacher;

}
