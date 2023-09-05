package br.com.example.davidarchanjo.kafka;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class KafkaProducer {

    @Value("${kafka.config.topic.id}")
    private String topicId;
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(final @RequestBody String order) {
        final String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topicId, key, order);
    }

}
