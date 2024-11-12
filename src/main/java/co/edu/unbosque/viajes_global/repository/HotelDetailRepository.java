package co.edu.unbosque.viajes_global.repository;

import co.edu.unbosque.viajes_global.model.HotelDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelDetailRepository extends CrudRepository<HotelDetail, Integer> {
    List<HotelDetail> findAll();
}
