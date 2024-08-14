package com.example.order_service.restuser;

import com.example.order_service.dto.UserDto;
import com.example.order_service.util.RestClient;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final RestClient<UserDto> restClient;

    public UserService(RestClient<UserDto> restClient) {
        this.restClient = restClient;
    }

    public UserDto getUser(int userId) {
        return restClient.get("user/"+userId, UserDto.class);
    }
}
