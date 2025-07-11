package com.luan.funds.config;


import com.luan.funds.model.Fundo;
import com.luan.funds.repository.FundoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader  implements CommandLineRunner {

    private final FundoRepository fundoRepository;

    public DataLoader(FundoRepository fundoRepository) {
        this.fundoRepository = fundoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Fundo f1 = new Fundo();
        f1.setNome("Fundo Alpha");
        f1.setClasse("Renda Fixa");
        f1.setTaxaAdmin(new BigDecimal("0.9"));
        f1.setGestor("XP Investimentos");
        f1.setPatrimonioLiquido(new BigDecimal("15000000.00"));

        Fundo f2 = new Fundo();
        f2.setNome("Fundo Beta");
        f2.setClasse("Ações");
        f2.setTaxaAdmin(new BigDecimal("1.5"));
        f2.setGestor("BTG Pactual");
        f2.setPatrimonioLiquido(new BigDecimal("8000000.00"));

        fundoRepository.save(f1);
        fundoRepository.save(f2);

        System.out.println("Fundos de teste inseridos no banco.");
    }
}
