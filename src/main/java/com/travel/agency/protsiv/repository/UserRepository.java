package com.travel.agency.protsiv.repository;


import com.travel.agency.protsiv.dto.UserDto;
import com.travel.agency.protsiv.model.User;

import java.util.List;

public interface UserRepository {
    User getUser(String login);

    List<User> getAllUsers();

    User saveUser(User user);

    User updateUser(String login, UserDto userDto);

    void deleteUser(String login);

}
