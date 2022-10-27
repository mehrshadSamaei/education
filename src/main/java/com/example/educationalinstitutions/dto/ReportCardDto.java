package com.example.educationalinstitutions.dto;

import com.example.educationalinstitutions.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportCardDto extends BaseDto<Long> {
    private Double grade;
    private CourseDto course;
    private StudentDto student;
}
