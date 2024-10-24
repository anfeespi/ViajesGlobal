package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.UserDTO;
import co.edu.unbosque.viajes_global.service.UserService;
import co.edu.unbosque.viajes_global.util.Encryption;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDTO user) {
        user.setUserPassword(Encryption.hashPassword(user.getUserPassword()));
        boolean state = userService.registerUser(user, user.getNotificationMethod());
        return state ? ResponseEntity.status(HttpStatus.CREATED).body("Successfully Registered " + user.getUserNames()) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong...");
    }
}
