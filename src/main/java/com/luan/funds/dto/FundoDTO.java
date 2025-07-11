package com.luan.funds.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class FundoDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Classe é obrigatória")
    private String classe;

    @DecimalMin(value = "0.0", inclusive = false, message = "Taxa de administração deve ser positiva")
    private BigDecimal taxaAdmin;

    @NotBlank(message = "Gestor é obrigatório")
    private String gestor;

    @NotNull(message = "Patrimônio líquido é obrigatório")
    @DecimalMin(value="0.0", inclusive = true, message = "Patrimônio líquido deve ser maior ou igual a zero")
    private BigDecimal patrimonioLiquido;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public BigDecimal getTaxaAdmin() {
        return taxaAdmin;
    }

    public void setTaxaAdmin(BigDecimal taxaAdmin) {
        this.taxaAdmin = taxaAdmin;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public BigDecimal getPatrimonioLiquido() {
        return patrimonioLiquido;
    }

    public void setPatrimonioLiquido(BigDecimal patrimonioLiquido) {
        this.patrimonioLiquido = patrimonioLiquido;
    }
}
