package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.dto.PackageDetailBuilder;
import co.edu.unbosque.viajes_global.dto.PackageDetailDTO;
import co.edu.unbosque.viajes_global.exception.ElementNotPresentException;
import co.edu.unbosque.viajes_global.exception.UserNotFoundException;
import co.edu.unbosque.viajes_global.model.User;
import co.edu.unbosque.viajes_global.repository.PackageDetailRepository;
import co.edu.unbosque.viajes_global.repository.UserRepository;
import co.edu.unbosque.viajes_global.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageDetailService {
    @Autowired
    private PackageDetailRepository packageDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataMapper dataMapper;

    public PackageDetailService() {

    }

    public PackageDetailDTO getById(Integer id) {
        if (packageDetailRepository.existsById(id))
            return dataMapper.packageDetailToPackageDetailDTO(packageDetailRepository.findById(id).get());
        throw new ElementNotPresentException();
    }

    public PackageDetailBuilder createPackage(String user) {
        return new PackageDetailBuilder().setUser(user);
    }

    public PackageDetailBuilder addHotel(PackageDetailBuilder builder, Integer hotel) {
        return builder.addHotel(hotel);
    }

    public PackageDetailBuilder addFlight(PackageDetailBuilder builder, Integer flight) {
        return builder.addFlight(flight);
    }

    public PackageDetailBuilder addExcursion(PackageDetailBuilder builder, Integer excursion) {
        return builder.addExcursion(excursion);
    }

    public PackageDetailDTO purchase(PackageDetailBuilder builder) throws UserNotFoundException {
        PackageDetailDTO packageDetailDTO = builder.build();
        return dataMapper.packageDetailToPackageDetailDTO(packageDetailRepository.save(dataMapper.packageDetailDTOToPackageDetail(packageDetailDTO)));
    }

    public List<PackageDetailDTO> getAllByUser(String id) {
        User user = userRepository.findById(id).get();
        return packageDetailRepository.findByUser(user).stream().map(packageDetail -> dataMapper.packageDetailToPackageDetailDTO(packageDetail)).toList();
    }

}
