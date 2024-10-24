package co.edu.unbosque.viajes_global.repository;

import co.edu.unbosque.viajes_global.model.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Integer> {
}
