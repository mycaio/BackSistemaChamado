package com.example.BackSistemaChamado.service;

import com.example.BackSistemaChamado.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listarTodos();

    Usuario buscarPorId(Long id);

    Usuario criar(Usuario usuario);

    Usuario atualizar(Long id, Usuario usuario);

    void deletar(Long id);

}