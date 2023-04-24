package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findUserById(Long id);
    List<User> getAllUsers();
    void saveUser(User user);
    boolean deleteUser(long id);
    Optional<User> findByUserName(String username);
    boolean check(User user);
    List<Role> getAllRoles();
    public void updateUser(Long id, User user);
}
