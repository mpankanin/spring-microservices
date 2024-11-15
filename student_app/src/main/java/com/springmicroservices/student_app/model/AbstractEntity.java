package com.springmicroservices.student_app.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
//import jakarta.persistence.SequenceGenerator;
import lombok.Getter;

@MappedSuperclass
@Getter
//@SequenceGenerator(name = "sequenceIdGenerator", initialValue = 20000, allocationSize = 1)
abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceIdGenerator")
    protected Long id;

}
