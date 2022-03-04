package com.example.demotiendaclase.Users.User.Application;

import com.example.demotiendaclase.Users.User.Domain.Ports.UserRepository;
import com.example.demotiendaclase.Users.User.Domain.User;
import com.example.demotiendaclase.Users.User.Domain.ValueObject.UserEmail;
import com.example.demotiendaclase.Users.User.Domain.ValueObject.UserId;
import com.example.demotiendaclase.Users.User.Domain.ValueObject.UserName;
import com.example.demotiendaclase.Users.User.Domain.ValueObject.UserPassword;

public class UserCreator {

    private UserRepository repository;


    public UserCreator(UserRepository repository)
    {
        this.repository = repository;
    }

    //Creates a User
    public void execute(String userId, String userName, String userEmail, String password){
        User user = User.create(new UserId(userId), new UserName(userName),
                    new UserEmail(userEmail), new UserPassword(password));

        //Save it on repository
        repository.save(user);
    }

}
