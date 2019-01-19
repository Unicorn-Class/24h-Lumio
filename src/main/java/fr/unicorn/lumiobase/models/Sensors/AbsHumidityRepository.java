package fr.unicorn.lumiobase.models.Sensors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsHumidityRepository extends CrudRepository<AbsHumidity, Integer> {
}
