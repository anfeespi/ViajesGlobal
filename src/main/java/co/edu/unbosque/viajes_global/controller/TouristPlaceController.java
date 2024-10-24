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

@RestController
@RequestMapping("/cities")
@CrossOrigin("*")
public class TouristPlaceController {

    @Autowired
    private TouristPlaceService touristPlaceService;

    public TouristPlaceController() {

    }

    @GetMapping("/show")
    public ResponseEntity<?> getTouristPlaces() {
        List<TouristPlaceDTO> ret = touristPlaceService.getAllTouristPlaces();

        return ret.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).body("There aren't some cities") : ResponseEntity.status(HttpStatus.OK).body(ret);
    }
}
