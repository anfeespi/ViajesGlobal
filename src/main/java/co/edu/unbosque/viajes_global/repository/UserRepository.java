package co.edu.unbosque.viajes_global.repository;

import co.edu.unbosque.viajes_global.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
