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

/**
 * Controlador para manejar los endpoints relacionados con los vuelos.
 *
 * @autor Andres Espitia, Johan Gomez, David Lopez, Kevin Peña
 */
@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    public FlightController() {

    }

    /**
     * Obtiene una lista paginada de detalles de vuelos.
     *
     * @param pageable Objeto que contiene la información de paginación.
     * @return ResponseEntity con la lista paginada de vuelos o NoContent si no hay vuelos.
     */
    @GetMapping
    public ResponseEntity<Page<FlightDetailDTO>> getAllFlights(@PageableDefault(size = 8) Pageable pageable) {
        Page<FlightDetailDTO> flights = flightService.getAllFlightsPageable(pageable);
        return flights.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(flights);
    }

    /**
     * Obtiene los detalles de un vuelo específico por su ID.
     *
     * @param id Identificador del vuelo.
     * @return ResponseEntity con los detalles del vuelo encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<FlightDetailDTO> getFlightById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(flightService.getFlightDetailById(id));
    }

    /**
     * Crea un nuevo vuelo.
     *
     * @param flightDetailDTO DTO con la información del vuelo a registrar.
     * @param uriBuilder Constructor para construir la URI del recurso creado.
     * @return ResponseEntity con el DTO del vuelo creado.
     * @throws ParseException Si hay un error al parsear datos de fecha.
     */
    @PostMapping
    public ResponseEntity<FlightDetailDTO> createFlight(@RequestBody FlightDetailDTO flightDetailDTO, UriComponentsBuilder uriBuilder) throws ParseException {
        FlightDetailDTO dto = flightService.registerFlight(flightDetailDTO);
        URI url = uriBuilder.path("/flight/{id}").buildAndExpand(dto.flightDetailId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }
}
