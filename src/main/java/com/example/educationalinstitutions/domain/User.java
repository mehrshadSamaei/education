package com.example.educationalinstitutions.domain;

import com.example.educationalinstitutions.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Date;
import java.util.UUID;

@MappedSuperclass
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class User extends BaseEntity<Long> {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username" , nullable = false , unique = true)
    private String username;
    @Column(name = "password" , nullable = false)
    private String password;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "age")
    private Integer age;
    @Column(name = "status")
    private Wait status = Wait.waiting;
    @Column(name = "national_code" , unique = true)
    private String nationalCode;
    @Column(name = "mobile_num")
    private String mobileNum;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
}
