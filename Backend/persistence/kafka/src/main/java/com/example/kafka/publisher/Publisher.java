package com.example.kafka.publisher;

import com.example.kafka.enums.Channel;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface Publisher {
    void publish(Channel channel, Object content);
    void publish(Channel channel, String key, Object content);
    void publish(Channel channel, Object content, BiConsumer<String, String> onSuccess, Consumer<Throwable> onFailure);
    void publish(Channel channel, String key, Object content, BiConsumer<String, String> onSuccess, Consumer<Throwable> onFailure);
}
