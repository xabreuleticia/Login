package com.example.LoginPUC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.LoginPUC.model.Usuario;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    private List<Usuario> usuarios = new ArrayList<>();

    private final EmailService emailService;

    public LoginController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String inicio() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/recoverpassword")
    public String recoverpassword() {
        return "recoverpassword";
    }

    @PostMapping("/register")
    public String cadastrar(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            @RequestParam String cpf,
            @RequestParam String endereco,
            @RequestParam String tipoUsuario,
            Model model) {

        // Mantém os dados preenchidos caso exista algum erro
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("cpf", cpf);
        model.addAttribute("endereco", endereco);
        model.addAttribute("tipoUsuario", tipoUsuario);

        // Campos vazios
        if (username.trim().isEmpty()
                || email.trim().isEmpty()
                || password.isEmpty()
                || confirmPassword.isEmpty()
                || cpf.trim().isEmpty()
                || endereco.trim().isEmpty()
                || tipoUsuario.trim().isEmpty()) {

            model.addAttribute("erro", "Preencha todos os campos.");
            return "register";
        }

        // E-mail inválido
        if (!email.contains("@") || !email.contains(".")) {

            model.addAttribute("erro", "Digite um e-mail válido.");
            return "register";
        }

        // Senhas diferentes
        if (!password.equals(confirmPassword)) {

            model.addAttribute("erro", "As senhas não coincidem.");
            return "register";
        }

        // Senha muito curta
        if (password.length() < 8) {

            model.addAttribute(
                    "erro",
                    "A senha deve ter pelo menos 8 caracteres."
            );

            return "register";
        }

        // Usuário ou e-mail já cadastrado
        for (Usuario usuario : usuarios) {

            if (usuario.getUsername().equalsIgnoreCase(username)) {

                model.addAttribute(
                        "erro",
                        "Este usuário já está cadastrado."
                );

                return "register";
            }

            if (usuario.getEmail().equalsIgnoreCase(email)) {

                model.addAttribute(
                        "erro",
                        "Este e-mail já está cadastrado."
                );

                return "register";
            }
        }

        // Cadastra o usuário
        Usuario novoUsuario = new Usuario(
                username,
                email,
                password,
                cpf,
                endereco,
                tipoUsuario
        );

        usuarios.add(novoUsuario);

        return "redirect:/login";
    }

    @PostMapping("/recoverpassword")
    public String recuperarSenha(
            @RequestParam String email,
            Model model) {

        if (email.trim().isEmpty()) {
            model.addAttribute("erro", "Preencha o e-mail.");
            return "recoverpassword";
        }

        if (!email.contains("@") || !email.contains(".")) {
            model.addAttribute("erro", "Digite um e-mail válido.");
            return "recoverpassword";
        }

        model.addAttribute("sucesso",
                "Se o e-mail estiver cadastrado, as instruções serão enviadas.");

        return "recoverpassword";
    }
}