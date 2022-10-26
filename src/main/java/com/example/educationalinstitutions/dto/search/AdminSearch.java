package com.example.educationalinstitutions.dto.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminSearch {
    private String firstName;
    private String lastName;
    private String username;
    private String mobileNum;
    private String email;

}
