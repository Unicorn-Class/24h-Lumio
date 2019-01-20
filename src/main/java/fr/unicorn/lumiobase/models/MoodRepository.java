package fr.unicorn.lumiobase.models;

import fr.unicorn.lumiobase.demo.Mood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodRepository extends CrudRepository<Mood, Integer> {

}