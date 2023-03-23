package com.dh.persistencia.demo.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String home() {
        return "<h1>Bienvenidos a la clinica</h1>";
    }
    @GetMapping("/user")
    public String user() {
        return "<h1>Bienvenido Usuario a la clinica</h1>";
    }
    @GetMapping("/admin")
    public String admin() {
        return "<h1>Bienvenido Administrador a la clinica</h1>";
    }
}
