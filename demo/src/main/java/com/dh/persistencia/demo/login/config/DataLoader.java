package com.dh.persistencia.demo.login.config;

import com.dh.persistencia.demo.login.entity.AppUser;
import com.dh.persistencia.demo.login.entity.AppUsuarioRoles;
import com.dh.persistencia.demo.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new AppUser("Juan", "juan", "juan_10@email.com", password, AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("Juana", "juana", "juanita_10@email.com", password2, AppUsuarioRoles.USER));

    }
}
