package co.edu.unbosque.viajes_global.repository;

import co.edu.unbosque.viajes_global.model.FlightDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightDetailRepository extends CrudRepository<FlightDetail, Integer> {
    List<FlightDetail> findAll();
}
