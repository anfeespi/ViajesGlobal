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

/**
 * Controlador para manejar los endpoints relacionados con los usuarios.
 *
 * @autor Andres Espitia, Johan Gomez, David Lopez, Kevin Peña
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EventManager eventManager;

    public UserController() {

    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param user DTO con la información del usuario a registrar.
     * @return ResponseEntity con mensaje de éxito o error.
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDTO user) {
        boolean state = userService.registerUser(user, user.notificationMethod());
        return state ? 
            ResponseEntity.status(HttpStatus.CREATED).body("Successfully Registered " + user.userNames()) : 
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong...");
    }

    /**
     * Inicia sesión de un usuario en el sistema.
     *
     * @param user Nombre de usuario.
     * @param password Contraseña del usuario.
     * @return ResponseEntity con los detalles del usuario logueado.
     * @throws UserNotFoundException Si el usuario no es encontrado.
     * @throws PasswordMismatchException Si la contraseña no coincide.
     */
    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestParam String user, @RequestBody String password) 
            throws UserNotFoundException, PasswordMismatchException {
        password = Encryption.hashPassword(password.replace("\"", ""));
        UserDTO response = userService.login(user, password);
        return ResponseEntity.ok().body(response);
    }

    /**
     * Obtiene los detalles de un usuario por su ID.
     *
     * @param id Identificador del usuario.
     * @return ResponseEntity con los detalles del usuario.
     * @throws UserNotFoundException Si el usuario no es encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id) throws UserNotFoundException {
        UserDTO response = userService.getById(id);
        return ResponseEntity.ok(response);
    }
}
