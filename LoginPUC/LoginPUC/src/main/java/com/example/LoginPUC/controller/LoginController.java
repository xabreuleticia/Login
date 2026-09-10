package com.example.LoginPUC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Restcontroller -> API REST -> BackEnd
// @Controller -> MVC -> FrontEnd + BackEnd
@Controller
public class LoginController {

    @GetMapping("/login") // http://localhost:8080/login
    public String login() {
        return "login";
        // Retorna o nome do arquivo TML (login.html)
        // que será renderizado
    }
    
}
