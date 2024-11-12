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

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    public HotelController() {

    }

    @GetMapping
    public ResponseEntity<Page<HotelDetailDTO>> getHotels(@PageableDefault(size = 8) Pageable pageable) {
        Page<HotelDetailDTO> hotels = hotelService.getAllHotelDetails(pageable);

        return hotels.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDetailDTO> getHotelById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(hotelService.getHotelById(id));
    }

    @PostMapping
    public ResponseEntity<HotelDetailDTO> createHotel(@Valid @RequestBody HotelDetailDTO hotelDetailDTO, UriComponentsBuilder uriBuilder) {
        HotelDetailDTO dto = hotelService.registerHotel(hotelDetailDTO);
        URI url = uriBuilder.path("/hotel/{id}").buildAndExpand(dto.hotelDetailId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }
}
