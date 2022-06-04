package ir.kafka.simple_messenger.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class Message {
    private Integer id;
    private String context;
    private String groupName;
    private Integer senderId;

}
