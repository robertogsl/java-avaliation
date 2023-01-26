package com.example.project.controller;

import com.example.project.model.Endereco;
import com.example.project.model.Pessoa;
import com.example.project.repository.EnderecoRepository;
import com.example.project.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @CrossOrigin
    @PostMapping("/pessoa/{id}")
    private ResponseEntity addEndereco(@PathVariable int id, @RequestBody Endereco novoEndereco) {

        List<Pessoa> pessoaList = pessoaRepository.findAll();

        for (Pessoa p : pessoaList) {
            if (p.getId() == id) {
                novoEndereco.setDefault(true);
                p.setEndereco(novoEndereco);

                for (Endereco e : p.getEndereco()) {
                    if (e.getDefault()) {
                        e.setDefault(false);
                    }
                }
                return ResponseEntity.status(201).build();
            }
        }

        return ResponseEntity.status(404).build();
    }
}
