package com.example.educationalinstitutions.dto;

import com.example.educationalinstitutions.base.BaseDto;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDto extends BaseDto<Long> {
    private String title;
    private Date startCourseDay;
    private Date endOfCourseDay;
    private TeacherDto teacher;
}
