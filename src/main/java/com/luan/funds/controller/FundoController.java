package com.luan.funds.controller;

import com.luan.funds.model.Fundo;
import com.luan.funds.repository.FundoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fundos")
public class FundoController {

    private final FundoRepository fundoRepository;

    public FundoController(FundoRepository fundoRepository) {
        this.fundoRepository = fundoRepository;
    }

    @GetMapping
    public List<Fundo> listar(){
        return fundoRepository.findAll();
    }

    @PostMapping
    public Fundo adicionar(@RequestBody Fundo fundo){
        return fundoRepository.save(fundo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fundo> buscarPorId(@PathVariable Long id){
        Optional<Fundo> fundo = fundoRepository.findById(id);
        return fundo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fundo> atualizar(@PathVariable Long id, @RequestBody Fundo fundoAtualizado){
        return fundoRepository.findById(id)
                .map(fundo -> {
                    fundo.setNome(fundoAtualizado.getNome());
                    fundo.setClasse(fundoAtualizado.getClasse());
                    fundo.setTaxaAdmin(fundoAtualizado.getTaxaAdmin());
                    fundo.setGestor(fundoAtualizado.getGestor());
                    fundo.setPatrimonioLiquido(fundoAtualizado.getPatrimonioLiquido());
                    Fundo atualizado = fundoRepository.save(fundo);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id){
        return fundoRepository.findById(id)
                .map(fundo -> {
                    fundoRepository.delete(fundo);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }

}
