package com.example.order_service.restuser;

import com.example.order_service.entity.User;
import com.example.order_service.util.RestClient;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final RestClient<User> restClient;

    public UserService(RestClient<User> restClient) {
        this.restClient = restClient;
    }

    public User getUser(int userId) {
        return restClient.get("user/"+userId, User.class);
    }
}
