package com.example.service;

import com.example.dto.UserGetDto;
import com.example.dto.UserPostDto;
import com.example.entity.User;
import com.example.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;


    public List<UserGetDto> getAllUsers() {
        return userRepository.findAll().stream().map(this::userToGetDto).toList();
    }

    public UserGetDto getUserById(Long id) {
        return userToGetDto(findUserById(id));
    }

    @Transactional
    public UserGetDto addUser(UserPostDto userPostDto) {
        User user = userDtoToUser(userPostDto);
        userRepository.persistAndFlush(user);
        if (userRepository.isPersistent(user)){
            return userToGetDto(user);
        }
        return null;
    }

    @Transactional
    public UserGetDto updateUser(Long id, UserPostDto userPostDto) {
        User user = findUserById(id);
        if (user != null){
            user.setName(userPostDto.getName());
            user.setUsername(userPostDto.getUsername());
            user.setPassword(userPostDto.getPassword());
            userRepository.persistAndFlush(user);
            if (userRepository.isPersistent(user)){
                return userToGetDto(user);
            }
        }
        return null;
    }

    @Transactional
    public boolean deleteUser(Long id) {
        return userRepository.deleteById(id);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id);
    }

    private User userDtoToUser(UserPostDto userPostDto) {
        User user = new User();
        user.setName(userPostDto.getName());
        user.setUsername(userPostDto.getUsername());
        user.setPassword(userPostDto.getPassword());
        return user;
    }

    private UserGetDto userToGetDto(User user) {
        return new UserGetDto(
                user.getId(),
                user.getName(),
                user.getUsername()
        );
    }
}
