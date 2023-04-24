package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.exception.CustomUserException;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUsername(username)
                .stream().map(user -> new User(user.getUsername(), user.getPassword(), user.getAuthorities()))
                .findFirst()
                .orElseThrow(() -> new CustomUserException("Пользователь не найден"));
    }
}
