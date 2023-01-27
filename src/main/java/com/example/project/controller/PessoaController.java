package com.example.project.controller;

import com.example.project.model.Endereco;
import com.example.project.model.Pessoa;
import com.example.project.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @CrossOrigin
    @PostMapping
    public ResponseEntity criarPessoa(@RequestBody Pessoa novaPessoa) {

        pessoaRepository.save(novaPessoa);

        return ResponseEntity.status(201).build();
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity editarPessoa(@PathVariable int id, @RequestBody Pessoa pessoaAtualizada) {

        pessoaAtualizada.setId(id);

        if (pessoaRepository.existsById(id)) {

            pessoaRepository.save(pessoaAtualizada);

            return ResponseEntity.status(200).build();
        }
        else {
            return ResponseEntity.status(404).build();
        }
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity listarPessoa() {

        List<Pessoa> lista = pessoaRepository.findAll();

        if (lista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(lista);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity consultarPessoa(@PathVariable int id) {

        List<Pessoa> listaPessoa = pessoaRepository.findAll();

        for (Pessoa p : listaPessoa) {
            if (p.getId() == id) {
                return ResponseEntity.status(200).body(p);
            }
        }

        return ResponseEntity.status(204).build();
    }

    @CrossOrigin
    @PostMapping("/{id}/endereco")
    private ResponseEntity addEndereco(@PathVariable int id, @RequestBody Endereco novoEndereco) {

        List<Pessoa> pessoaList = pessoaRepository.findAll();

        for (Pessoa p : pessoaList) {
            if (p.getId() == id) {
                for (Endereco e : p.getEndereco()) {
                    if (e.getDefault()) {
                        e.setDefault(false);
                    }
                }

                novoEndereco.setDefault(true);
                p.addEndereco(novoEndereco);
                pessoaRepository.save(p);

                return ResponseEntity.status(201).build();
            }
        }

        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @PutMapping("/{id}/endereco/{enderecoId}/default")
    private ResponseEntity setEnderecoPadrao(@PathVariable int id, @PathVariable int enderecoId) {

        List<Pessoa> pessoaList = pessoaRepository.findAll();

        for (Pessoa p : pessoaList) {
            if (p.getId() == id) {
                for (Endereco e : p.getEndereco()) {
                    if (e.getDefault()) {
                        e.setDefault(false);
                    }
                    if (e.getId() == enderecoId) {
                        e.setDefault(true);

                        pessoaRepository.save(p);

                        return ResponseEntity.status(200).build();
                    }
                }
            }
        }

        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @GetMapping("/{id}/endereco")
    private ResponseEntity listarEnderecos(@PathVariable int id) {

        List<Pessoa> pessoas = pessoaRepository.findAll();

        for (Pessoa p : pessoas) {
            if (p.getId() == id) {
                List<Endereco> enderecos = p.getEndereco();

                return ResponseEntity.status(200).body(enderecos);
            }
        }

        return ResponseEntity.status(204).build();
    }
}
