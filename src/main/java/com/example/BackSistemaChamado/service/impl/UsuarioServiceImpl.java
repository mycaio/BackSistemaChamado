package com.example.BackSistemaChamado.service.impl;

import com.example.BackSistemaChamado.entity.Usuario;
import com.example.BackSistemaChamado.repository.UsuarioRepository;
import com.example.BackSistemaChamado.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado. ID: " + id));
    }

    @Override
    public Usuario criar(Usuario usuario) {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Já existe um usuário com este e-mail.");
        }

        usuario.setId(null);

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {

        Usuario usuario = buscarPorId(id);

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setSenha(usuarioAtualizado.getSenha());
        usuario.setPerfil(usuarioAtualizado.getPerfil());

        return usuarioRepository.save(usuario);
    }

    @Override
    public void deletar(Long id) {

        Usuario usuario = buscarPorId(id);

        usuarioRepository.delete(usuario);
    }
}