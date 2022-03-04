package com.example.demotiendaclase.Users.User.Domain.Ports;

import com.example.demotiendaclase.Users.User.Domain.User;

import java.util.List;

public interface UserRepository {
    public void save(User user);
    public List<User> all();
}
