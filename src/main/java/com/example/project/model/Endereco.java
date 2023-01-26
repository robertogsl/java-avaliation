package com.example.project.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String logradouro;

    @NotNull
    private String cep;

    @NotNull
    private Integer numero;

    @NotNull
    private String cidade;

    @NotNull
    private Boolean isDefault = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}
