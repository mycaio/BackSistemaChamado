package com.example.BackSistemaChamado.controller;

import com.example.BackSistemaChamado.entity.Usuario;
import com.example.BackSistemaChamado.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.criar(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {

        return ResponseEntity.ok(
                usuarioService.atualizar(id, usuario)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        usuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}