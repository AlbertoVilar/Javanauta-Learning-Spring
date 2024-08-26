package dev.security.services;

import dev.security.entities.User;
import dev.security.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}
