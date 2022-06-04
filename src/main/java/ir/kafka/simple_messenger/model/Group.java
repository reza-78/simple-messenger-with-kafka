package ir.kafka.simple_messenger.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Group {
    private Integer id;
    private String name;
    @Setter
    private List<User> members;
    @Setter
    private List<Message> messages;

}
