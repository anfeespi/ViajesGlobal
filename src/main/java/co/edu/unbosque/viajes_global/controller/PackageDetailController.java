package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.PackageDetailBuilder;
import co.edu.unbosque.viajes_global.dto.PackageDetailDTO;
import co.edu.unbosque.viajes_global.exception.UserNotFoundException;
import co.edu.unbosque.viajes_global.service.PackageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controlador para manejar los endpoints relacionados con los paquetes turísticos.
 *
 * @autor Andres Espitia, Johan Gomez, David Lopez, Kevin Peña
 */
@RestController
@RequestMapping("/package")
public class PackageDetailController {
    
    @Autowired
    private PackageDetailService packageDetailService;

    public PackageDetailController() {

    }

    /**
     * Crea un nuevo paquete turístico para un usuario.
     *
     * @param user Identificador del usuario.
     * @return ResponseEntity con el constructor del paquete creado.
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PackageDetailBuilder> createPackage(@RequestHeader String user) {
        return ResponseEntity.accepted().body(packageDetailService.createPackage(user));
    }

    /**
     * Obtiene los paquetes turísticos de un usuario específico.
     *
     * @param user Identificador del usuario.
     * @return ResponseEntity con la lista de paquetes o NoContent si no hay paquetes.
     */
    @GetMapping
    public ResponseEntity<List<PackageDetailDTO>> getPackagesByUser(@RequestHeader String user) {
        return packageDetailService.getAllByUser(user).isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(packageDetailService.getAllByUser(user));
    }

    /**
     * Obtiene los detalles de un paquete específico por su ID.
     *
     * @param id Identificador del paquete.
     * @return ResponseEntity con los detalles del paquete.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PackageDetailDTO> getPackage(@PathVariable Integer id) {
        return ResponseEntity.accepted().body(packageDetailService.getById(id));
    }

    /**
     * Agrega un hotel a un paquete turístico.
     *
     * @param packageDetailBuilder Constructor del paquete.
     * @param hotel Identificador del hotel.
     * @return ResponseEntity con el constructor del paquete actualizado.
     */
    @PostMapping("/hotel/{hotel}")
    public ResponseEntity<PackageDetailBuilder> addHotel(@RequestBody PackageDetailBuilder packageDetailBuilder, @PathVariable Integer hotel) {
        return ResponseEntity.accepted().body(packageDetailService.addHotel(packageDetailBuilder, hotel));
    }

    /**
     * Agrega un vuelo a un paquete turístico.
     *
     * @param packageDetailBuilder Constructor del paquete.
     * @param flight Identificador del vuelo.
     * @return ResponseEntity con el constructor del paquete actualizado.
     */
    @PostMapping("/flight/{flight}")
    public ResponseEntity<PackageDetailBuilder> addFlight(@RequestBody PackageDetailBuilder packageDetailBuilder, @PathVariable Integer flight) {
        return ResponseEntity.accepted().body(packageDetailService.addFlight(packageDetailBuilder, flight));
    }

    /**
     * Agrega una excursión a un paquete turístico.
     *
     * @param packageDetailBuilder Constructor del paquete.
     * @param excursion Identificador de la excursión.
     * @return ResponseEntity con el constructor del paquete actualizado.
     */
    @PostMapping("/excursion/{excursion}")
    public ResponseEntity<PackageDetailBuilder> addExcursion(@RequestBody PackageDetailBuilder packageDetailBuilder, @PathVariable Integer excursion) {
        return ResponseEntity.accepted().body(packageDetailService.addExcursion(packageDetailBuilder, excursion));
    }

    /**
     * Realiza la compra de un paquete turístico.
     *
     * @param packageDetailBuilder Constructor del paquete.
     * @param uriComponentsBuilder Constructor para construir la URI del recurso creado.
     * @return ResponseEntity con el DTO del paquete comprado.
     * @throws UserNotFoundException Si el usuario no es encontrado.
     */
    @PostMapping("/purchase")
    public ResponseEntity<PackageDetailDTO> purchase(@RequestBody PackageDetailBuilder packageDetailBuilder, UriComponentsBuilder uriComponentsBuilder) throws UserNotFoundException {
        PackageDetailDTO dto = packageDetailService.purchase(packageDetailBuilder);
        URI url = uriComponentsBuilder.path("/package/{id}").buildAndExpand(dto.packageDetailId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }
}
