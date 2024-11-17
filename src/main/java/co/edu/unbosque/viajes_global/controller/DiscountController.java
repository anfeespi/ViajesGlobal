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

/**
 * Controlador para manejar los endpoints relacionados con los descuentos de vuelos, hoteles y excursiones.
 *
 * @autor Andres Espitia, Johan Gomez, David Lopez, Kevin Peña
 */
@RestController
@RequestMapping("/discount")
public class DiscountController {
    
    @Autowired
    private DiscountService discountService;

    /**
     * Crea un nuevo descuento para un vuelo.
     *
     * @param flightDiscountDTO DTO con la información del descuento de vuelo.
     * @param uriBuilder Constructor para construir la URI del recurso creado.
     * @return ResponseEntity con el DTO del descuento de vuelo creado.
     */
    @PostMapping("/flight")
    public ResponseEntity<FlightDiscountDTO> createDiscount(@RequestBody FlightDiscountDTO flightDiscountDTO, UriComponentsBuilder uriBuilder) {
        FlightDiscountDTO dto = discountService.addFlightDiscount(flightDiscountDTO);
        URI url = uriBuilder.path("/discount/flight/{id}").buildAndExpand(dto.flightDiscountId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }

    /**
     * Obtiene un descuento de vuelo por su ID.
     *
     * @param id Identificador del descuento de vuelo.
     * @return ResponseEntity con el DTO del descuento de vuelo encontrado.
     */
    @GetMapping("/flight/{id}")
    public ResponseEntity<FlightDiscountDTO> getFlightDiscountById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(discountService.getFlightById(id));
    }

    /**
     * Crea un nuevo descuento para un hotel.
     *
     * @param hotelDiscountDTO DTO con la información del descuento de hotel.
     * @param uriBuilder Constructor para construir la URI del recurso creado.
     * @return ResponseEntity con el DTO del descuento de hotel creado.
     */
    @PostMapping("/hotel")
    public ResponseEntity<HotelDiscountDTO> createDiscount(@RequestBody HotelDiscountDTO hotelDiscountDTO, UriComponentsBuilder uriBuilder) {
        HotelDiscountDTO dto = discountService.addHotelDiscount(hotelDiscountDTO);
        URI url = uriBuilder.path("/discount/hotel/{id}").buildAndExpand(dto.hotelDiscountId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }

    /**
     * Obtiene un descuento de hotel por su ID.
     *
     * @param id Identificador del descuento de hotel.
     * @return ResponseEntity con el DTO del descuento de hotel encontrado.
     */
    @GetMapping("/hotel/{id}")
    public ResponseEntity<HotelDiscountDTO> getHotelDiscountById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(discountService.getHotelById(id));
    }

    /**
     * Crea un nuevo descuento para una excursión.
     *
     * @param excursionDiscountDTO DTO con la información del descuento de excursión.
     * @param uriBuilder Constructor para construir la URI del recurso creado.
     * @return ResponseEntity con el DTO del descuento de excursión creado.
     */
    @PostMapping("/excursion")
    public ResponseEntity<ExcursionDiscountDTO> createDiscount(@RequestBody ExcursionDiscountDTO excursionDiscountDTO, UriComponentsBuilder uriBuilder) {
        ExcursionDiscountDTO dto = discountService.addExcursionDiscount(excursionDiscountDTO);
        URI url = uriBuilder.path("/discount/excursion/{id}").buildAndExpand(dto.excursionDiscountId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }

    /**
     * Obtiene un descuento de excursión por su ID.
     *
     * @param id Identificador del descuento de excursión.
     * @return ResponseEntity con el DTO del descuento de excursión encontrado.
     */
    @GetMapping("/excursion/{id}")
    public ResponseEntity<ExcursionDiscountDTO> getExcursionDiscountById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(discountService.getExcursionById(id));
    }
}
