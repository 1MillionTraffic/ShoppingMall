package com.example.api.component.httpClient;

import java.util.Map;

public interface HttpClient {
    <T> T request(String url, Class<T> responseType);
    <T> T request(String url, Class<T> responseType, Map<String, String> headers);
}
