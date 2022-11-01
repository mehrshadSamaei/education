package com.example.educationalinstitutions.dto;

import com.example.educationalinstitutions.domain.User;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto extends UserDto {
    private List<ReportCardDto> reportCards;
    private CourseDto course;
}
