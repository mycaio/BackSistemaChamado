package com.example.BackSistemaChamado.controller;

import com.example.BackSistemaChamado.entity.Chamado;
import com.example.BackSistemaChamado.service.ChamadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @GetMapping
    public ResponseEntity<List<Chamado>> listarTodos() {
        return ResponseEntity.ok(chamadoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chamado> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(chamadoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Chamado> criar(@RequestBody Chamado chamado) {
        return ResponseEntity.ok(chamadoService.criar(chamado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chamado> atualizar(
            @PathVariable Long id,
            @RequestBody Chamado chamado) {

        return ResponseEntity.ok(chamadoService.atualizar(id, chamado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        chamadoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}