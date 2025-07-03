package com.desafio.alura.consumindoapi.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnderecoPersistence {
    public void salvarEmArquivo(String nomeDoArquivo, String json) throws IOException {
        File file = new File(nomeDoArquivo);
        if(file.exists()){
            if(file.isFile()) {
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(nomeDoArquivo));
                fileWriter.write(json);
                fileWriter.newLine();
                fileWriter.close();
            } else {
                System.err.println("Não é um arquivo.");
                System.out.println("Conteúdo do diretório: ");
                String[] diretorio = file.list();

                if(diretorio != null){
                    for(String item : diretorio){
                        System.out.println(" " + item);
                    }
                }
            }
        } else {
            System.out.println("Arquivo não existe.");
        }
    }
}
