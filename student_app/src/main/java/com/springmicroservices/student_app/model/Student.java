package com.springmicroservices.student_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends AbstractEntity{

    //@Column - necessary only for customization, when it's not specified it's implicitly added with default values
    private String name;

    //@Column
    private String surname;

    @Column(unique = true) // added because of the customization
    private String email;

    private StudentStatus status;



}
