package com.example.BackSistemaChamado.service;

import com.example.BackSistemaChamado.entity.Chamado;

import java.util.List;

public interface ChamadoService {

    List<Chamado> listarTodos();

    Chamado buscarPorId(Long id);

    Chamado criar(Chamado chamado);

    Chamado atualizar(Long id, Chamado chamado);

    void deletar(Long id);
}