package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.ExcursionDiscountDTO;
import co.edu.unbosque.viajes_global.dto.FlightDiscountDTO;
import co.edu.unbosque.viajes_global.dto.HotelDiscountDTO;
import co.edu.unbosque.viajes_global.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/discount")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @PostMapping("/flight")
    public ResponseEntity<FlightDiscountDTO> createDiscount(@RequestBody FlightDiscountDTO flightDiscountDTO, UriComponentsBuilder uriBuilder) {
        FlightDiscountDTO dto = discountService.addFlightDiscount(flightDiscountDTO);
        URI url = uriBuilder.path("/discount/flight/{id}").buildAndExpand(dto.flightDiscountId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<FlightDiscountDTO> getFlightDiscountById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(discountService.getFlightById(id));
    }

    @PostMapping("/hotel")
    public ResponseEntity<HotelDiscountDTO> createDiscount(@RequestBody HotelDiscountDTO hotelDiscountDTO, UriComponentsBuilder uriBuilder) {
        HotelDiscountDTO dto = discountService.addHotelDiscount(hotelDiscountDTO);
        URI url = uriBuilder.path("/discount/hotel/{id}").buildAndExpand(dto.hotelDiscountId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<HotelDiscountDTO> getHotelDiscountById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(discountService.getHotelById(id));
    }

    @PostMapping("/excursion")
    public ResponseEntity<ExcursionDiscountDTO> createDiscount(@RequestBody ExcursionDiscountDTO excursionDiscountDTO, UriComponentsBuilder uriBuilder) {
        ExcursionDiscountDTO dto = discountService.addExcursionDiscount(excursionDiscountDTO);
        URI url = uriBuilder.path("/discount/excursion/{id}").buildAndExpand(dto.excursionDiscountId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }

    @GetMapping("/excursion/{id}")
    public ResponseEntity<ExcursionDiscountDTO> getExcursionDiscountById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(discountService.getExcursionById(id));
    }
}
