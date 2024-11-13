package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.dto.FlightDetailDTO;
import co.edu.unbosque.viajes_global.exception.ElementNotPresentException;
import co.edu.unbosque.viajes_global.model.Flight;
import co.edu.unbosque.viajes_global.model.FlightDetail;
import co.edu.unbosque.viajes_global.repository.FlightDetailRepository;
import co.edu.unbosque.viajes_global.repository.FlightRepository;
import co.edu.unbosque.viajes_global.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightDetailRepository flightDetailRepository;

    @Autowired
    private FlightRepository flightsRepository;

    @Autowired
    private DataMapper dataMapper;

    public FlightService() {

    }

    public List<FlightDetailDTO> getAllFlightsDetails() {
        return flightDetailRepository.findAll().stream().map(dataMapper::flightDetailToFlightDetailDTO).toList();
    }

    public Page<FlightDetailDTO> getAllFlightsPageable(Pageable pageable) {
        List<FlightDetailDTO> flightDetailDTOS = getAllFlightsDetails();
        return new PageImpl<>(flightDetailDTOS, pageable, flightDetailDTOS.size());
    }

    public FlightDetailDTO getFlightDetailById(Integer id) {
        if (flightsRepository.existsById(id)) {
            return dataMapper.flightDetailToFlightDetailDTO(flightDetailRepository.findById(id).get());
        }
        throw new ElementNotPresentException();
    }

    public FlightDetailDTO registerFlight(FlightDetailDTO flightDetailDTO) throws ParseException {
        FlightDetail entity = dataMapper.flightDetailDTOToFlightDetail(flightDetailDTO);
        Flight toSave = entity.getFlight();
        flightsRepository.save(toSave);
        return dataMapper.flightDetailToFlightDetailDTO(flightDetailRepository.save(entity));
    }
}
