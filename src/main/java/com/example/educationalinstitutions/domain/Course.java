package com.example.educationalinstitutions.domain;

import com.example.educationalinstitutions.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "coursess")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course extends BaseEntity<Long> {
    @Column(name = "title" , unique = true)
    private String title;
    @Column(name = "start_course_day")
    private Date startCourseDay;
    @Column(name = "end_of_course_day")
    private Date endOfCourseDay;
    @ManyToOne
    private Teacher teacher;
    @OneToMany(mappedBy = "course")
    private List<ReportCard> reportCards;
    @OneToMany(mappedBy = "course")
    private List<Student> students;

}
