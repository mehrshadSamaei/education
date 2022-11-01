package com.example.educationalinstitutions.dto;

import com.example.educationalinstitutions.base.BaseDto;
import com.example.educationalinstitutions.domain.Wait;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
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
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 6, max = 16)
    private String password;

    private Date dob;

    private Integer age;

    private String status = Wait.waiting.getConvertString();
    @NotBlank
    private String nationalCode;
    @NotBlank
    private String mobileNum;

    private String address;

    private String email;
}
