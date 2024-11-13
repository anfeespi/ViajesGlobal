package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.FlightDetailDTO;
import co.edu.unbosque.viajes_global.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    public FlightController() {

    }

    @GetMapping
    public ResponseEntity<Page<FlightDetailDTO>> getAllFlights(@PageableDefault(size = 8) Pageable pageable) {
        Page<FlightDetailDTO> flights = flightService.getAllFlightsPageable(pageable);

        return flights.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDetailDTO> getFlightById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(flightService.getFlightDetailById(id));
    }

    @PostMapping
    public ResponseEntity<FlightDetailDTO> createFlight(@RequestBody FlightDetailDTO flightDetailDTO, UriComponentsBuilder uriBuilder) throws ParseException {
        FlightDetailDTO dto = flightService.registerFlight(flightDetailDTO);
        URI url = uriBuilder.path("/flight/{id}").buildAndExpand(dto.flightDetailId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }
}
