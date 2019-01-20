package fr.unicorn.lumiobase.models.Sensors;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PressureRepository extends CrudRepository<Pressure, Integer> {
    public List<Pressure> findAll(Sort sort);
}
