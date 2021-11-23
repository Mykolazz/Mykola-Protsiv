package com.travel.agency.protsiv.repository.repositoryImpl;

import com.travel.agency.protsiv.dto.UserDto;
import com.travel.agency.protsiv.model.User;
import com.travel.agency.protsiv.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public User getUser(String login) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found!"));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public User saveUser(User user){
        user.setId(users.size());
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(String login, UserDto userDto) {

            User tempUser = users.stream()
                        .filter(user -> user.getLogin().equals(login))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("User is not found!"));
            tempUser.setLogin(userDto.getLogin());
            tempUser.setName(userDto.getName());
            tempUser.setEmail(userDto.getEmail());
            tempUser.setAge(userDto.getAge());

        return tempUser;
    }

    @Override
    public void deleteUser(String login) {
        users.removeIf(user -> user.getLogin().equals(login));
    }
}
