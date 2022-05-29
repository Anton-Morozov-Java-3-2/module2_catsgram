package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;

import java.util.HashSet;

@RestController
@RequestMapping("/users")
public class UserController {
    HashSet<User> users = new HashSet<>();

    @GetMapping
    public HashSet<User> getUsers(){
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody User user) throws InvalidEmailException, UserAlreadyExistException {
        if (users.contains(user)) {
            throw new UserAlreadyExistException();
        } else {
            checkEmail(user);
            users.add(user);
            return user;
        }
    }

    @PutMapping
    public User updateUser(@RequestBody User user) throws InvalidEmailException{
        checkEmail(user);
        users.add(user);
        return user;
    }

    void checkEmail(User user) throws InvalidEmailException {
        if (user.getEmail() == null) {
            throw new InvalidEmailException();
        } else if (user.getEmail().isBlank() || user.getEmail().isEmpty()) {
            throw new InvalidEmailException();
        }
    }
}

class UserAlreadyExistException extends Exception {}

class InvalidEmailException extends Exception {}
