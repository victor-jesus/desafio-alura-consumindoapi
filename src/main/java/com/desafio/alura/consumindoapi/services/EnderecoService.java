package com.desafio.alura.consumindoapi.services;

import com.desafio.alura.consumindoapi.controller.ClientHttpAdapter;
import com.desafio.alura.consumindoapi.domain.Endereco;
import com.desafio.alura.consumindoapi.domain.EnderecoRecord;
import com.desafio.alura.consumindoapi.persistence.EnderecoPersistence;
import com.desafio.alura.consumindoapi.services.command.SalvaEnderecoCommand;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpResponse;

public class EnderecoService {
    public Endereco getEndereco(String caminho, String uri) throws IOException, InterruptedException {
        ClientHttpAdapter clientHttpAdapter = new ClientHttpAdapter();
        HttpResponse<String> response = clientHttpAdapter.get(uri);

        Gson gson = new Gson();
        EnderecoRecord enderecoRecord = gson.fromJson(response.body(), EnderecoRecord.class);

        EnderecoPersistence enderecoPersistence = new EnderecoPersistence();

        SalvaEnderecoCommand salvaEnderecoCommand = new SalvaEnderecoCommand(enderecoPersistence, caminho, response.body());
        salvaEnderecoCommand.execute();

        return new Endereco(enderecoRecord);
    }

}
