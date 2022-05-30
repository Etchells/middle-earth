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
}
