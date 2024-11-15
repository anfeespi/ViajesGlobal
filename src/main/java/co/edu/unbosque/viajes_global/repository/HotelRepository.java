package co.edu.unbosque.viajes_global.repository;

import co.edu.unbosque.viajes_global.model.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {
    List<Hotel> findAll();
}
