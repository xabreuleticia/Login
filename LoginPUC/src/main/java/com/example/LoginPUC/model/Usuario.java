package com.example.LoginPUC.model;

public class Usuario {

    private String username;
    private String email;
    private String password;
    private String cpf;
    private String endereco;
    private String tipoUsuario;

    public Usuario(String username, String email, String password,
                   String cpf, String endereco, String tipoUsuario) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.endereco = endereco;
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}