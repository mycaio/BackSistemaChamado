package com.example.BackSistemaChamado.service.impl;

import com.example.BackSistemaChamado.entity.Chamado;
import com.example.BackSistemaChamado.enums.StatusChamado;
import com.example.BackSistemaChamado.repository.ChamadoRepository;
import com.example.BackSistemaChamado.service.ChamadoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChamadoServiceImpl implements ChamadoService {

    private final ChamadoRepository chamadoRepository;

    public ChamadoServiceImpl(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    @Override
    public List<Chamado> listarTodos() {
        return chamadoRepository.findAll();
    }

    @Override
    public Chamado buscarPorId(Long id) {
        return chamadoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Chamado não encontrado. ID: " + id));
    }

    @Override
    public Chamado criar(Chamado chamado) {

        chamado.setId(null);
        chamado.setStatus(StatusChamado.ABERTO);
        chamado.setDataAbertura(LocalDateTime.now());

        return chamadoRepository.save(chamado);
    }

    @Override
    public Chamado atualizar(Long id, Chamado chamadoAtualizado) {

        Chamado chamadoExistente = buscarPorId(id);

        chamadoExistente.setTitulo(chamadoAtualizado.getTitulo());
        chamadoExistente.setDescricao(chamadoAtualizado.getDescricao());
        chamadoExistente.setPrioridade(chamadoAtualizado.getPrioridade());
        chamadoExistente.setStatus(chamadoAtualizado.getStatus());

        return chamadoRepository.save(chamadoExistente);
    }

    @Override
    public void deletar(Long id) {

        Chamado chamado = buscarPorId(id);

        chamadoRepository.delete(chamado);
    }
}