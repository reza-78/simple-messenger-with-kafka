package ir.kafka.simple_messenger.control;

import ir.kafka.simple_messenger.model.*;
import ir.kafka.simple_messenger.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {
    private final GroupService groupService;

    @PostMapping("/")
    private void init() {
        User user1 = new User(1, "user1", List.of(), List.of());
        User user2 = new User(2, "user2", List.of(), List.of());
        User user3 = new User(3, "user3", List.of(), List.of());
        User user4 = new User(4, "user4", List.of(), List.of());
        User user5 = new User(5, "user5", List.of(), List.of());
        User user6 = new User(6, "user6", List.of(), List.of());

        Group group1 = new Group(1, "Group1", List.of(), List.of());
        Group group2 = new Group(2, "Group2", List.of(), List.of());
        Group group3 = new Group(3, "Group3", List.of(), List.of());

//        register(user1, group1);
//        register(user2, group1);
//        register(user3, group1);
//        register(user4, group1);
//
//        register(user4, group2);
//        register(user5, group2);
//
//        register(user6, group3);
    }

    // todo create dto
    @PostMapping("/message")
    private HttpStatus sendMessage(@RequestBody Message message) {
        groupService.sendMessage(message);
        return HttpStatus.CREATED;
    }

//    private void register(User user, Group group) {
//        addGroup(user, group);
//        addMember(user, group);
//    }
//
//    private void addGroup(User user, Group group) {
//        List<Group> groups = user.getGroups();
//        groups.add(group);
//        user.setGroups(groups);
//    }
//
//    private void addMember(User user, Group group) {
//        List<User> members = group.getMembers();
//        members.add(user);
//        group.setMembers(members);
//    }
}
