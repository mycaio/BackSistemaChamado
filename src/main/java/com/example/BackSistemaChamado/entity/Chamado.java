package com.example.BackSistemaChamado.entity;

import com.example.BackSistemaChamado.enums.Prioridade;
import com.example.BackSistemaChamado.enums.StatusChamado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chamados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 2000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusChamado status;

    @Column(nullable = false)
    private LocalDateTime dataAbertura;
}