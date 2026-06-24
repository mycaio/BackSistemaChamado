package com.example.BackSistemaChamado.controller;

import com.example.BackSistemaChamado.dto.LoginRequest;
import com.example.BackSistemaChamado.dto.LoginResponse;
import com.example.BackSistemaChamado.entity.Usuario;
import com.example.BackSistemaChamado.repository.UsuarioRepository;
import com.example.BackSistemaChamado.security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request
    ) {

        Usuario usuario = usuarioRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado")
                );

        if (!usuario.getSenha().equals(request.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.gerarToken(usuario.getEmail());

        return new LoginResponse(token);
    }
}