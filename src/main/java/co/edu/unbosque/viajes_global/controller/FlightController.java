package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.FlightDTO;
import co.edu.unbosque.viajes_global.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    public FlightController() {

    }

    @GetMapping
    public ResponseEntity<Page<FlightDTO>> getAllFlights(@PageableDefault(size = 8) Pageable pageable) {
        Page<FlightDTO> flights = flightService.getAllFlightsPageable(pageable);

        return flights.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(flights);
    }

    @PostMapping
    public ResponseEntity<String> addFlight(@RequestBody FlightDTO flight) {
        flightService.createFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body("The flight is on the web!");
    }
}
