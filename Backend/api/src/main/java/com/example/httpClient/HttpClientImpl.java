package com.example.httpClient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class HttpClientImpl implements HttpClient {
    @Override
    public <T> T request(String url, Class<T> responseType) {
        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .build();

        return  webClient.get()
                .retrieve()
                .bodyToMono(responseType)
                .block();

    }

    @Override
    public <T> T request(String url, Class<T> responseType, Map<String, String> headers){
        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .build();

        return  webClient.get()
                .headers(header -> headers.forEach(header::add))
                .retrieve()
                .bodyToMono(responseType)
                .block();
    }
}
