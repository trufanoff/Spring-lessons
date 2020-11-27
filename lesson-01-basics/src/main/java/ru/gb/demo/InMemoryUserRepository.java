package ru.gb.demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class InMemoryUserRepository implements UserRepository{
    private List<User> users;

    @PostConstruct
    public void init(){
        this.users = new ArrayList<User>();
        this.users.add(new User(1L, "Bob", "Bob@gmail.com"));
        this.users.add(new User(2L, "John", "John@gmail.com"));
    }

    @Override
    public List<User> findAllUsers(){
        return Collections.unmodifiableList(users);
    }

    @Override
    public void addUser(User user){
        users.add(user);
    }


}
