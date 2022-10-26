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
public class UserDto extends BaseDto<Long> {
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Date dob;

    private Integer age;

    private String status = "waiting";

    private String nationalCode;

    private String mobileNum;

    private String address;

    private String email;
}
