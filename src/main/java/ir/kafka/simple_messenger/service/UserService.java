package ir.kafka.simple_messenger.service;

import ir.kafka.simple_messenger.model.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final KafkaTemplate<String, Message> kafkaTemplate;

    @KafkaListener(topics = "topicGroup1", groupId = "user1", containerFactory = "kafkaListenerContainerFactoryForReceiveMessages")
    public void receiveMessageG1U1(@Payload Message message,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.GROUP_ID) String group) {
        log.info("message {} in topic {} and group {} received by user {}", message, topic, group, message.getSenderId());
        kafkaTemplate.send("topicView1", message);
    }

    @KafkaListener(topics = "topicGroup1", groupId = "user2", containerFactory = "kafkaListenerContainerFactoryForReceiveMessages")
    public void receiveMessageG1U2(@Payload Message message,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.GROUP_ID) String group) {
        log.info("message {} in topic {} and group {} received by user {}", message, topic, group, message.getSenderId());
        kafkaTemplate.send("topicView1", message);
    }

    @KafkaListener(topics = "topicGroup1", groupId = "user3", containerFactory = "kafkaListenerContainerFactoryForReceiveMessages")
    public void receiveMessageG1U3(@Payload Message message,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.GROUP_ID) String group) {
        log.info("message {} in topic {} and group {} received by user {}", message, topic, group, message.getSenderId());
        kafkaTemplate.send("topicView1", message);
    }

    @KafkaListener(topics = "topicGroup1", groupId = "user4", containerFactory = "kafkaListenerContainerFactoryForReceiveMessages")
    public void receiveMessageG1U4(@Payload Message message,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.GROUP_ID) String group) {
        log.info("message {} in topic {} and group {} received by user {}", message, topic, group, message.getSenderId());
        kafkaTemplate.send("topicView1", message);
    }

    @KafkaListener(topics = "topicGroup2", groupId = "user4", containerFactory = "kafkaListenerContainerFactoryForReceiveMessages")
    public void receiveMessageG2U4(@Payload Message message,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.GROUP_ID) String group) {
        log.info("message {} in topic {} and group {} received by user {}", message, topic, group, message.getSenderId());
        kafkaTemplate.send("topicView2", message);
    }

    @KafkaListener(topics = "topicGroup2", groupId = "user5", containerFactory = "kafkaListenerContainerFactoryForReceiveMessages")
    public void receiveMessageG2U5(@Payload Message message,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.GROUP_ID) String group) {
        log.info("message {} in topic {} and group {} received by user {}", message, topic, group, message.getSenderId());
        kafkaTemplate.send("topicView2", message);
    }

    @KafkaListener(topics = "topicGroup3", groupId = "user6", containerFactory = "kafkaListenerContainerFactoryForReceiveMessages")
    public void receiveMessageG3U6(@Payload Message message,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                               @Header(KafkaHeaders.GROUP_ID) String group) {
        log.info("message {} in topic {} and group {} received by user {}", message, topic, group, message.getSenderId());
        kafkaTemplate.send("topicView3", message);
    }
}
