package co.edu.unbosque.viajes_global.repository;

import co.edu.unbosque.viajes_global.model.PackageDetail;
import co.edu.unbosque.viajes_global.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PackageDetailRepository extends CrudRepository<PackageDetail, Integer> {
    List<PackageDetail> findByUser(User user);
}
