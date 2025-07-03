package com.desafio.alura.consumindoapi.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttpAdapter {
    public HttpResponse<String> get(String uri) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if(httpResponse.statusCode() == 200) {
            return httpResponse;
        } else {
            throw new IOException("Erro HTTP: " + httpResponse.statusCode() + " Status code");
        }
    }
}
