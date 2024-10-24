package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.dto.FlightDTO;
import co.edu.unbosque.viajes_global.model.Flight;
import co.edu.unbosque.viajes_global.repository.FlightRepository;
import co.edu.unbosque.viajes_global.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    private final DataMapper dataMapper;

    public FlightService() {
        dataMapper = new DataMapper();
    }

    public List<FlightDTO> getAllFlights() {
        List<Flight> flights = (List<Flight>) flightRepository.findAll();
        List<FlightDTO> dtos = new ArrayList<>();
        for(Flight flight : flights) {
            dtos.add(dataMapper.flightToFlightDTO(flight));
        }

        return dtos;
    }
}
