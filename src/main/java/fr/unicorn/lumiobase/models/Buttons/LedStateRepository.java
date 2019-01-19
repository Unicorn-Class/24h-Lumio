package fr.unicorn.lumiobase.models.Buttons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedStateRepository extends CrudRepository<LedState, Integer> {
}
