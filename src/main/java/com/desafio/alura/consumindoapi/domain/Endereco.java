package com.desafio.alura.consumindoapi.domain;

public class Endereco {
    String cep;
    String rua;
    String bairro;
    String estado;
    String municipio;
    String uf;

    public Endereco(EnderecoRecord enderecoRecord) {
        this.cep = enderecoRecord.cep();
        this.rua = enderecoRecord.logradouro();
        this.bairro = enderecoRecord.bairro();
        this.estado = enderecoRecord.estado();
        this.municipio = enderecoRecord.localidade();
        this.uf = enderecoRecord.uf();
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return "Cep :'" + cep + '\'' +
                "\nRua : '" + rua + '\'' +
                "\nBairro : '" + bairro + '\'' +
                "\nEstado : '" + estado + '\'' +
                "\nMunicipio : '" + municipio + '\'' +
                "\nUf : '" + uf + '\'';
    }
}
