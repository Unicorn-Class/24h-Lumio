package fr.unicorn.lumiobase.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface MusicRepository extends CrudRepository<Music,String>{

    }
