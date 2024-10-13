package co.edu.unbosque.viajes_global.repository;

import co.edu.unbosque.viajes_global.model.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderRepository extends CrudRepository<Gender, Integer> {
}
