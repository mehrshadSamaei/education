package com.example.educationalinstitutions.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Version;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDto<ID extends Serializable> implements Serializable {
    private ID id;
}
