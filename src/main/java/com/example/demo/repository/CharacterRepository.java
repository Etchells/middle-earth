package com.example.demo.repository;

import com.example.demo.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

    // Find by firstName
    @Query(value = "SELECT * FROM character WHERE first_name = ?1",nativeQuery = true)
    List<Character>findByFirstName(String firstName);

    // Find by lastName
    @Query(value = "SELECT * FROM character WHERE last_name = ?1",nativeQuery = true)
    List<Character>findByLastName(String lastName);

    // Find by location
    @Query(value = "SELECT * FROM character WHERE location = ?1",nativeQuery = true)
    List<Character>findByLocation(String location);

    // Find by race
    @Query(value = "SELECT * FROM character WHERE race = ?1",nativeQuery = true)
    List<Character>findByRace(String race);

    // Find by location and race
    @Query(value = "SELECT * FROM character WHERE location = ?1 and race = ?2",nativeQuery = true)
    List<Character>findByLocationAndRace(String location, String race);
}
