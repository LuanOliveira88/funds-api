package com.luan.funds.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Fundo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String classe;

    private BigDecimal taxaAdmin;

    private String gestor;

    private BigDecimal patrimonioLiquido;

}
