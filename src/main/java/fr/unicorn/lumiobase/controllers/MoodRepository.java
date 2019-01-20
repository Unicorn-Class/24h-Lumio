package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.demo.Mood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodRepository extends CrudRepository<Mood, String> {

}