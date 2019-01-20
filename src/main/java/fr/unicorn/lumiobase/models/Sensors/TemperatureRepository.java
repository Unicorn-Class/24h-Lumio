package fr.unicorn.lumiobase.models.Sensors;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {
    public List<Temperature> findAll(Sort sort);
}
