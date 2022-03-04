package com.example.demotiendaclase.Users.User.Infrastructure.Adapters;

import com.example.demotiendaclase.Users.User.Domain.Ports.UserRepository;
import com.example.demotiendaclase.Users.User.Domain.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

    private  List<User> users = new ArrayList<>();
    @Override
    public void save(User user) {
        users.add(user);

    }

    @Override
    public List<User> all() {
        return users;
    }
}
