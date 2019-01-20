package fr.unicorn.lumiobase.models.Sensors;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumidityRepository extends CrudRepository<Humidity, Integer> {
    public List<Humidity> findAll(Sort sort);
}
