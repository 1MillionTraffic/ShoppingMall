package com.example.kafka.publisher;

import com.example.kafka.enums.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer implements Publisher{
    private final KafkaTemplate<String ,Object> kafkaTemplate;

    @Override
    public void publish(Channel channel, Object content) {
        publish(channel, content,
                (producer, record) -> log.info("producer_info: " + producer + " record_info: " + record ),
                (ex) -> log.info("error: " + ex.toString())
        );
    }

    @Override
    public void publish(Channel channel, String key, Object content) {
        publish(channel, key, content,
                (producer, record) -> log.info("producer_info: " + producer + " record_info: " + record ),
                (ex) -> log.info("error: " + ex.toString())
        );
    }

    @Override
    public void publish(Channel channel, Object content, BiConsumer<String, String> onSuccess, Consumer<Throwable> onFailure) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(channel.GetChannelName(), content);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                onFailure.accept(ex);
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                var producerInfo = result.getProducerRecord().toString();
                var recordMetaData = result.getRecordMetadata().toString();

                onSuccess.accept(producerInfo, recordMetaData);
            }
        });
    }

    @Override
    public void publish(Channel channel, String key, Object content, BiConsumer<String, String> onSuccess, Consumer<Throwable> onFailure) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(channel.GetChannelName(), key, content);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                onFailure.accept(ex);
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                var producerInfo = result.getProducerRecord().toString();
                var recordMetaData = result.getRecordMetadata().toString();

                onSuccess.accept(producerInfo, recordMetaData);
            }
        });
    }
}
