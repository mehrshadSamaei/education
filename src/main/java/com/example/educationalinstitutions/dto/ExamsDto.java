package com.example.educationalinstitutions.dto;

import com.example.educationalinstitutions.base.BaseDto;
import lombok.*;

import java.sql.Time;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExamsDto extends BaseDto<Long> {
    private String title;
    private String description;
    private Time time;
    private CourseDto course;
}
