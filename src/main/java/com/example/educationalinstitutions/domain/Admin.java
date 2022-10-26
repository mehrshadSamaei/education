package com.example.educationalinstitutions.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Admin extends User{

}
