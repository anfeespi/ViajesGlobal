package co.edu.unbosque.viajes_global.repository;

import co.edu.unbosque.viajes_global.model.ExcursionDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExcursionDetailRepository extends CrudRepository<ExcursionDetail, Integer> {
    List<ExcursionDetail> findAll();
}
