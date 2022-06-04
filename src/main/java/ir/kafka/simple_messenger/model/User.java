package ir.kafka.simple_messenger.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {
    private Integer id;
    private String username;
    @Setter
    private List<Group> groups;
    @Setter
    private List<Message> messages;
}
