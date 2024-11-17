package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.HotelDetailDTO;
import co.edu.unbosque.viajes_global.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Controller class for managing hotel-related operations.
 * Provides endpoints for getting a list of hotels, getting a hotel by its ID,
 * and creating a new hotel.
 * 
 * @autor Andrés Espitia, Johan Gómez, David López, Kevin Peña
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

    /**
     * Default constructor for the controller.
     */
    public HotelController() {
    }

    /**
     * Endpoint to retrieve a paginated list of hotel details.
     * 
     * @param pageable Pagination information.
     * @return A paginated list of hotel details or no content if no hotels exist.
     */
    @GetMapping
    public ResponseEntity<Page<HotelDetailDTO>> getHotels(@PageableDefault(size = 8) Pageable pageable) {
        Page<HotelDetailDTO> hotels = hotelService.getAllHotelDetails(pageable);

        return hotels.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(hotels);
    }

    /**
     * Endpoint to retrieve a specific hotel by its ID.
     * 
     * @param id The ID of the hotel to retrieve.
     * @return The details of the hotel with the given ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<HotelDetailDTO> getHotelById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(hotelService.getHotelById(id));
    }

    /**
     * Endpoint to create a new hotel.
     * 
     * @param hotelDetailDTO The details of the hotel to create.
     * @param uriBuilder A utility to build the URI of the newly created hotel.
     * @return The created hotel details and the URI where the new hotel can be accessed.
     */
    @PostMapping
    public ResponseEntity<HotelDetailDTO> createHotel(@Valid @RequestBody HotelDetailDTO hotelDetailDTO, UriComponentsBuilder uriBuilder) {
        HotelDetailDTO dto = hotelService.registerHotel(hotelDetailDTO);
        URI url = uriBuilder.path("/hotel/{id}").buildAndExpand(dto.hotelDetailId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }
}
