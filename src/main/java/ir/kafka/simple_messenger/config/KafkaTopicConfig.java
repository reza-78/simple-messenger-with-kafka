package ir.kafka.simple_messenger.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kafka-server}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic buildGroup1Topic() {
        return new NewTopic("topicGroup1", 1, (short) 3);
    }

    @Bean
    public NewTopic buildGroup2Topic() {
        return new NewTopic("topicGroup2", 1, (short) 3);
    }

    @Bean
    public NewTopic buildGroup3Topic() {
        return new NewTopic("topicGroup3", 1, (short) 3);
    }

    @Bean
    public NewTopic buildView1Topic() {
        return new NewTopic("topicView1", 3, (short) 3);
    }

    @Bean
    public NewTopic buildView2Topic() {
        return new NewTopic("topicView2", 3, (short) 3);
    }

    @Bean
    public NewTopic buildView3Topic() {
        return new NewTopic("topicView3", 3, (short) 3);
    }
}

