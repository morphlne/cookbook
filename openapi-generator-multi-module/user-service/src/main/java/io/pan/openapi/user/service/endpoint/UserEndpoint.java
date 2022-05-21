package io.pan.openapi.user.service.endpoint;

import io.pan.openapi.user.api.endpoint.UserApi;
import io.pan.openapi.user.api.model.CreateUserRequest;
import io.pan.openapi.user.api.model.User;
import io.pan.openapi.user.service.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserEndpoint implements UserApi {

    private final Map<Long, User> users = new HashMap<>();

    @PostConstruct
    public void init() {
        users.put(
                1L,
                new User()
                        .id(1L)
                        .name("J. Doe")
        );
    }

    @Override
    public ResponseEntity<User> createUser(CreateUserRequest createUserRequest) {
        final var newUserId = users.keySet().stream()
                                      .max(Long::compare)
                                      .orElse(0L) + 1;
        users.put(
                newUserId,
                new User()
                        .id(newUserId)
                        .name(createUserRequest.getName())
        );
        return new ResponseEntity<>(
                users.get(newUserId),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<User> getUserById(Long userId) {
        if (users.containsKey(userId)) {
            return new ResponseEntity<>(
                    users.get(userId),
                    HttpStatus.OK
            );
        }
        throw new UserException(
                HttpStatus.NOT_FOUND,
                "User not found"
        );
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(
                new ArrayList<>(users.values()),
                HttpStatus.OK
        );
    }

}
