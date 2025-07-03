package com.desafio.alura.consumindoapi.services.command;

import com.desafio.alura.consumindoapi.domain.Endereco;
import com.desafio.alura.consumindoapi.services.EnderecoService;

public class GetEnderecoCommand implements Command {
    String caminho;
    String uri;
    EnderecoService enderecoService = new EnderecoService();

    public GetEnderecoCommand(String caminho, String uri){
        this.caminho = caminho;
        this.uri = uri;
    }

    @Override
    public void execute() {
        try{
            Endereco endereco = enderecoService.getEndereco(caminho, uri);
            System.out.println(endereco);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
