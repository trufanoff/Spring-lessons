package ru.gb.demo;

import java.util.List;

public interface UserRepository {
    List<User> findAllUsers();

    void addUser(User user);
}
