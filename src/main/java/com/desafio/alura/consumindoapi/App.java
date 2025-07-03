package com.desafio.alura.consumindoapi;

import com.desafio.alura.consumindoapi.services.command.Command;
import com.desafio.alura.consumindoapi.services.command.GetEnderecoCommand;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CEP (Sem traços): ");
        String cep = scanner.next();

        System.out.print("Digite onde quer salvar o endereço: ");
        String arquivo = scanner.next();

        String uri = "https://viacep.com.br/ws/"+ cep +"/json/";

        Command getEnderecoCommand = new GetEnderecoCommand(arquivo, uri);

        getEnderecoCommand.execute();
    }
}