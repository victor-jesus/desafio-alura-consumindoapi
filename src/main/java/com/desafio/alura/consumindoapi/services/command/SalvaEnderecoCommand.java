package com.desafio.alura.consumindoapi.services.command;

import com.desafio.alura.consumindoapi.persistence.EnderecoPersistence;

public class SalvaEnderecoCommand implements Command{
    EnderecoPersistence enderecoPersistence;
    String caminho;
    String json;

    public SalvaEnderecoCommand(EnderecoPersistence enderecoPersistence, String caminho, String json){
        this.enderecoPersistence = enderecoPersistence;
        this.caminho = caminho;
        this.json = json;
    }

    @Override
    public void execute() {
        try{
            enderecoPersistence.salvarEmArquivo(caminho, json);
            System.out.println("Salvo em arquivo " + caminho + " com sucesso");
        } catch (Exception e) {
            System.err.println("Erro ao obter endereço: " + e.getMessage());
        }
    }
}
