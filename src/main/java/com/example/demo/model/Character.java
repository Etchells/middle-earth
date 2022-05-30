package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Character {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;

    private int age;

    private String location;

    private String race;

}
