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

@RestController
@RequestMapping("/package")
public class PackageDetailController {
    @Autowired
    private PackageDetailService packageDetailService;

    public PackageDetailController() {

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PackageDetailBuilder> createPackage(@RequestHeader String user) {
        return ResponseEntity.accepted().body(packageDetailService.createPackage(user));
    }

    @GetMapping
    public ResponseEntity<List<PackageDetailDTO>> getPackagesByUser(@RequestHeader String user) {
        return packageDetailService.getAllByUser(user).isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(packageDetailService.getAllByUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageDetailDTO> getPackage(@PathVariable Integer id) {
        return ResponseEntity.accepted().body(packageDetailService.getById(id));
    }

    @PostMapping("/hotel/{hotel}")
    public ResponseEntity<PackageDetailBuilder> addHotel(@RequestBody PackageDetailBuilder packageDetailBuilder, @PathVariable Integer hotel) {
        return ResponseEntity.accepted().body(packageDetailService.addHotel(packageDetailBuilder, hotel));
    }

    @PostMapping("/flight/{flight}")
    public ResponseEntity<PackageDetailBuilder> addFlight(@RequestBody PackageDetailBuilder packageDetailBuilder, @PathVariable Integer flight) {
        return ResponseEntity.accepted().body(packageDetailService.addFlight(packageDetailBuilder, flight));
    }

    @PostMapping("/excursion/{excursion}")
    public ResponseEntity<PackageDetailBuilder> addExcursion(@RequestBody PackageDetailBuilder packageDetailBuilder, @PathVariable Integer excursion) {
        return ResponseEntity.accepted().body(packageDetailService.addExcursion(packageDetailBuilder, excursion));
    }

    @PostMapping("/purchase")
    public ResponseEntity<PackageDetailDTO> purchase(@RequestBody PackageDetailBuilder packageDetailBuilder, UriComponentsBuilder uriComponentsBuilder) throws UserNotFoundException {
        PackageDetailDTO dto = packageDetailService.purchase(packageDetailBuilder);
        URI url = uriComponentsBuilder.path("/package/{id}").buildAndExpand(dto.packageDetailId()).toUri();
        return ResponseEntity.created(url).body(dto);
    }
}
