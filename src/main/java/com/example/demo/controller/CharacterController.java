package com.example.demo.controller;

import com.example.demo.model.Character;
import com.example.demo.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/")
@CrossOrigin
public class CharacterController {

    @Autowired
    private CharacterService service;

    // Read all
    @GetMapping(path = "/readfromdb")
    public ResponseEntity<List<Character>>getAll(){
        return new ResponseEntity<List<Character>>(this.service.readAll(), HttpStatus.OK);
    }

    // Find by id
    @GetMapping(path = "/findbyid/{id}")
    public ResponseEntity<Character>findById(@PathVariable("id")int id){
        return new ResponseEntity<Character>(this.service.findById(id), HttpStatus.FOUND);
    }

    // Create character
    @PostMapping(path = "/create")
    public ResponseEntity<Character>create(@RequestBody Character character){
        return new ResponseEntity<Character>(this.service.create(character), HttpStatus.CREATED);
    }

    // Update character
    @PutMapping(path = "update/{id}")
    public ResponseEntity<Character>update(@PathVariable("id")int id, @RequestBody Character character){
        return new ResponseEntity<Character>(this.service.update(id, character), HttpStatus.ACCEPTED);
    }

    // Delete by id
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Boolean>delete(@PathVariable("id")int id){
        return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
    }

    // Add a list of characters
    @PostMapping(path = "/addlist")
    public List<Character> addList(@RequestBody List<Character> character){
        return this.service.createList(character);
    }

    // Find by firstName
    @PostMapping(path = "/findByFirstName/{firstName}")
    public ResponseEntity<List<Character>>findByFirstName(@PathVariable String firstName){
        return new ResponseEntity<List<Character>>(this.service.findByFirstName(firstName),HttpStatus.OK);
    }

    // Find by lastName
    @PostMapping(path = "/findByLastName/{lastName}")
    public ResponseEntity<List<Character>>findByLastName(@PathVariable String lastName){
        return new ResponseEntity<List<Character>>(this.service.findByLastName(lastName),HttpStatus.OK);
    }

    // Find by location
    @PostMapping(path = "/findByLocation/{location}")
    public ResponseEntity<List<Character>>findByLocation(@PathVariable String location){
        return new ResponseEntity<List<Character>>(this.service.findByLocation(location),HttpStatus.OK);
    }

    // Find by race
    @PostMapping(path = "/findByRace/{race}")
    public ResponseEntity<List<Character>>findByRace(@PathVariable String race){
        return new ResponseEntity<List<Character>>(this.service.findByRace(race),HttpStatus.OK);
    }

    // Find by location and race
    @PostMapping(path = "/findByLocationAndRace/{location}/{race}")
    public ResponseEntity<List<Character>>findByLocationAndRace(@PathVariable String location, @PathVariable String race){
        return new ResponseEntity<List<Character>>(this.service.findByLocationAndRace(location, race),HttpStatus.OK);
    }
}
