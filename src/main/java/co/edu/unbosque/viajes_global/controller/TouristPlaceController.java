package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.TouristPlaceDTO;
import co.edu.unbosque.viajes_global.service.TouristPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador para manejar los endpoints relacionados con los lugares turísticos.
 *
 * @autor Andres Espitia, Johan Gomez, David Lopez, Kevin Peña
 */
@RestController
@RequestMapping("/cities")
@CrossOrigin("*")
public class TouristPlaceController {

    @Autowired
    private TouristPlaceService touristPlaceService;

    public TouristPlaceController() {

    }

    /**
     * Obtiene todos los lugares turísticos disponibles.
     *
     * @return ResponseEntity con la lista de lugares turísticos o NoContent si no hay lugares disponibles.
     */
    @GetMapping
    public ResponseEntity<?> getTouristPlaces() {
        List<TouristPlaceDTO> ret = touristPlaceService.getAllTouristPlaces();
        return ret.isEmpty() ? 
            ResponseEntity.status(HttpStatus.NO_CONTENT).body("There aren't any tourist places available") :
            ResponseEntity.status(HttpStatus.OK).body(ret);
    }
}
