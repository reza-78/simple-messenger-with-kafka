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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class GroupService {
    private final KafkaTemplate<String, Message> kafkaTemplate;
    // k = messageId    v = viewCounts
    private final Map<Integer, Integer> messageViewCounts = new HashMap<>();

    public void sendMessage(Message message) {
        kafkaTemplate.send("topic" + message.getGroupName(), message);
    }

    @KafkaListener(id = "kafka-batch", topics = "topicView1", groupId = "countingViewsGroup", containerFactory = "kafkaListenerContainerFactoryForCountingViews")
    public void countViews1(@Payload List<Message> messages,
                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                           @Header(KafkaHeaders.GROUP_ID) String groupId) {
        log.info("_______________start processing batch_________________");
        for (Message message : messages) {
            log.info("message {} in topic {} and group {} received", message, topic, groupId);
            addViews(message);
        }
        log.info("_______________all messages in the batch consumed________________");

    }

    @KafkaListener(topics = "topicView2", groupId = "countingViewsGroup", containerFactory = "kafkaListenerContainerFactoryForCountingViews")
    public void countViews2(@Payload List<Message> messages,
                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                           @Header(KafkaHeaders.GROUP_ID) String groupId) {
        log.info("_______________start processing batch_________________");
        for (Message message : messages) {
            log.info("message {} in topic {} and group {} received", message, topic, groupId);
            addViews(message);
        }
        log.info("_______________all messages in the batch consumed________________");

    }

    @KafkaListener(topics = "topicView3", groupId = "countingViewsGroup", containerFactory = "kafkaListenerContainerFactoryForCountingViews")
    public void countViews3(@Payload List<Message> messages,
                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                           @Header(KafkaHeaders.GROUP_ID) String groupId) {
        log.info("_______________start processing batch_________________");
        for (Message message : messages) {
            log.info("message {} in topic {} and group {} received", message, topic, groupId);
            addViews(message);
        }
        log.info("_______________all messages in the batch consumed________________");
    }

    private void addViews(Message message) {
        int messageId = message.getId();
        if (messageViewCounts.containsKey(messageId)) {
            messageViewCounts.put(messageId, messageViewCounts.get(messageId) + 1);
        } else {
            messageViewCounts.put(messageId, 1);
        }
        log.info("message {} views is {}", messageId, messageViewCounts.get(messageId));
    }

}
