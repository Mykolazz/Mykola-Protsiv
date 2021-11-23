package com.travel.agency.protsiv.service;

import com.travel.agency.protsiv.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUser(String login);

    List<UserDto> getAllUsers();

    UserDto saveUser(UserDto userDto);

    UserDto updateUser(String login, UserDto userDto);

    void deleteUser(String login);
}
