package com.example.educationalinstitutions.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherDto extends UserDto {
    private String Specialty;
    private Integer workExperience;
}
