package br.com.example.davidarchanjo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Value("${kafka.config.topic.id}")
    private String topicId;

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name(topicId).build();
	}
}