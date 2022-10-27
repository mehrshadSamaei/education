package com.example.educationalinstitutions.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Admin")
@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Admin extends User{
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
