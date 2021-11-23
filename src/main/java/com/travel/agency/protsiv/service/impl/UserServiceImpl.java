package com.travel.agency.protsiv.service.impl;

import com.travel.agency.protsiv.dto.UserDto;
import com.travel.agency.protsiv.model.User;
import com.travel.agency.protsiv.repository.UserRepository;
import com.travel.agency.protsiv.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String login) {
        log.info("getUser by login {}", login);
        User user = userRepository.getUser(login);
        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        log.info("get all users");
        return userRepository.getAllUsers().stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        log.info("createUser with login {}", userDto.getLogin());
        User user = mapUserDtoToUser(userDto);
        user = userRepository.saveUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String login, UserDto userDto) {
        log.info("updateUser with login {}", login);
        User user = userRepository.updateUser(login, userDto);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String login) {
        log.info("deleteUser with login {}", login);
        userRepository.deleteUser(login);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .login(userDto.getLogin())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .age(userDto.getAge())
                .build();
    }
}
