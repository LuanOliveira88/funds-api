package com.luan.funds.controller;

import com.luan.funds.dto.FundoDTO;
import com.luan.funds.model.Fundo;
import com.luan.funds.repository.FundoRepository;
import jakarta.validation.Valid;
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
    public ResponseEntity<Fundo> adicionar(@Valid @RequestBody FundoDTO fundoDTO){
        Fundo fundo = converterDtoParaEntidade(fundoDTO);
        Fundo salvo = fundoRepository.save(fundo);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fundo> buscarPorId(@PathVariable Long id){
        Optional<Fundo> fundo = fundoRepository.findById(id);
        return fundo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fundo> atualizar(@PathVariable Long id, @Valid @RequestBody FundoDTO fundoDTO){
        return fundoRepository.findById(id)
                .map(fundo -> {
                    atualizarEntidadeComDto(fundo, fundoDTO);
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

    private Fundo converterDtoParaEntidade(FundoDTO dto){
        Fundo fundo = new Fundo();
        fundo.setNome(dto.getNome());
        fundo.setClasse(dto.getClasse());
        fundo.setTaxaAdmin(dto.getTaxaAdmin());
        fundo.setGestor(dto.getGestor());
        fundo.setPatrimonioLiquido(dto.getPatrimonioLiquido());
        return fundo;
    }

    private void atualizarEntidadeComDto(Fundo fundo, FundoDTO dto){
        fundo.setNome(dto.getNome());
        fundo.setClasse(dto.getClasse());
        fundo.setTaxaAdmin(dto.getTaxaAdmin());
        fundo.setGestor(dto.getGestor());
        fundo.setPatrimonioLiquido(dto.getPatrimonioLiquido());
    }
}
