package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.dto.TouristPlaceDTO;
import co.edu.unbosque.viajes_global.model.TouristPlace;
import co.edu.unbosque.viajes_global.repository.TouristPlaceRepository;
import co.edu.unbosque.viajes_global.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TouristPlaceService {
    @Autowired
    private TouristPlaceRepository touristPlaceRepository;

    private DataMapper dataMapper;

    public TouristPlaceService() {
        dataMapper = new DataMapper();
    }

    public List<TouristPlaceDTO> getAllTouristPlaces() {
        List<TouristPlace> touristPlaces = (List<TouristPlace>) touristPlaceRepository.findAll();
        List<TouristPlaceDTO> touristPlaceDTOs = new ArrayList<>();
        for (TouristPlace touristPlace : touristPlaces) {
            touristPlaceDTOs.add(dataMapper.touristPlaceToTouristPlaceDTO(touristPlace));
        }

        return touristPlaceDTOs;
    }
}
