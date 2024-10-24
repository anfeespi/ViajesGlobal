package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.FlightDTO;
import co.edu.unbosque.viajes_global.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin("*")
public class FlightController {
    @Autowired
    private FlightService flightService;

    public FlightController() {

    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllFlights() {
        List<FlightDTO> flights = flightService.getAllFlights();

        return flights.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(flights);
    }
}
