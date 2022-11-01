package com.example.educationalinstitutions.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@EqualsAndHashCode
public class Admin extends User{
//    to many default lazy and to one default eager
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
}
