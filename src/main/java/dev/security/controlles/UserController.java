package dev.security.controlles;

import dev.security.entities.User;
import dev.security.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    public final UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User entity = userService.save(user);
        return ResponseEntity.ok(entity);
    }

}
