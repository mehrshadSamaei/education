package com.example.educationalinstitutions.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

// data permission message type error code error \ into class
// translate error example 500 or 400
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionData implements Serializable {
    private String message;
}
