package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Set;

@Component
public class Start implements ApplicationListener<ContextRefreshedEvent> {

    private final UserService userService;

    public Start(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");
        Set<Role> role1 = Set.of(admin);
        Set<Role> role2 = Set.of(user);
        User user1 = new User("qwerty", "12345", "Ruslan" ,"Zaitsev","men",  role1);
        userService.saveUser(user1);
        User user2 = new User("qwerty12", "56789", "Oleg", "Petrov","men" , role2);
        userService.saveUser(user2);
    }
}

