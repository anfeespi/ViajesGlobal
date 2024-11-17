package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.ExcursionDetailDTO;
import co.edu.unbosque.viajes_global.service.ExcursionService;
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
 * Controlador para manejar los endpoints relacionados con las excursiones.
 *
 * @autor Andres Espitia, Johan Gomez, David Lopez, Kevin Peña
 */
@RestController
@RequestMapping("/excursion")
public class ExcursionController {

    @Autowired
    private ExcursionService excursionService;

    public ExcursionController() {

    }

    /**
     * Obtiene una lista paginada de detalles de excursiones.
     *
     * @param pageable Objeto que contiene la información de paginación.
     * @return ResponseEntity con la lista paginada de excursiones o NoContent si no hay excursiones.
     */
    @GetMapping
    public ResponseEntity<Page<ExcursionDetailDTO>> getExcursions(@PageableDefault(size = 8) Pageable pageable) {
        Page<ExcursionDetailDTO> excursions = excursionService.getAllExcursions(pageable);
        return excursions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(excursions);
    }

    /**
     * Obtiene los detalles de una excursión específica por su ID.
     *
     * @param id Identificador de la excursión.
     * @return ResponseEntity con los detalles de la excursión encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExcursionDetailDTO> getExcursionById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(excursionService.getExcursionById(id));
    }

    /**
     * Crea una nueva excursión.
     *
     * @param excursionDTO DTO con la información de la excursión a registrar.
     * @param uriComponentsBuilder Constructor para construir la URI del recurso creado.
     * @return ResponseEntity con el DTO de la excursión creada.
     */
    public ResponseEntity<ExcursionDetailDTO> createExcursion(@Valid @RequestBody ExcursionDetailDTO excursionDTO, UriComponentsBuilder uriComponentsBuilder) {
        ExcursionDetailDTO dto = excursionService.registerExcursion(excursionDTO);
        URI url = uriComponentsBuilder.path("/hotel/{id}").buildAndExpand(dto.excursionDetailId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }
}
