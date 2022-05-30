package com.example.demo.service;

import com.example.demo.model.Character;
import com.example.demo.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    public CharacterRepository repo;

    public CharacterService(CharacterRepository repo){
        super();
        this.repo = repo;
    }

    // Read all
    public List<Character> readAll(){
        return this.repo.findAll();
    }

    // Find by id
    public Character findById(int id){
        return this.repo.findById(id).orElseThrow();
    }

    // Create character
    public Character create(Character character){
        return this.repo.saveAndFlush(character);
    }

    // Update
    public Character update(int id, Character character){
        Character exists = this.repo.getById(id);
        exists.setFirstName(character.getFirstName());
        exists.setLastName(character.getLastName());
        exists.setAge(character.getAge());
        exists.setLocation(character.getLocation());
        exists.setRace(character.getRace());
        Character updated = this.repo.save(exists);
        return updated;
    }

    // Delete
    public Boolean delete(int id){
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
