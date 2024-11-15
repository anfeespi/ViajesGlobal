package co.edu.unbosque.viajes_global.controller;

import co.edu.unbosque.viajes_global.dto.UserDTO;
import co.edu.unbosque.viajes_global.exception.PasswordMismatchException;
import co.edu.unbosque.viajes_global.exception.UserNotFoundException;
import co.edu.unbosque.viajes_global.service.UserService;
import co.edu.unbosque.viajes_global.util.Encryption;
import co.edu.unbosque.viajes_global.util.EventManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EventManager eventManager;

    public UserController() {

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDTO user) {
        boolean state = userService.registerUser(user, user.notificationMethod());
        return state ? ResponseEntity.status(HttpStatus.CREATED).body("Successfully Registered " + user.userNames()) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong...");
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestParam String user, @RequestBody String password) throws UserNotFoundException, PasswordMismatchException {
        password = Encryption.hashPassword(password.replace("\"", ""));
        UserDTO response = userService.login(user, password);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id) throws UserNotFoundException {
        UserDTO response = userService.getById(id);

        return ResponseEntity.ok(response);
    }
}
