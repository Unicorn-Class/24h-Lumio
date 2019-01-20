package fr.unicorn.lumiobase.models.Sensors;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsHumidityRepository extends CrudRepository<AbsHumidity, Integer> {
    public List<AbsHumidity> findAll(Sort sort);
}
