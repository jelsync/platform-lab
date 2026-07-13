package com.holaMundo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/api/hola")
    public String holaMundo() {
        return "Hola Mundo";
    }

    @GetMapping("/api/saludo")
    public String saludo() {
        return "Hola, bienvenido a Spring Boot";
    }

    @Value("${mensaje:DEFAULT}")
    private String mensaje;

    @GetMapping("/api/secret")
    public String secret() {
        return mensaje;
    }
}