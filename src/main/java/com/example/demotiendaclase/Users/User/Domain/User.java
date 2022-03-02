package com.example.demotiendaclase.Users.User.Domain;

import com.example.demotiendaclase.Users.User.Domain.ValueObject.*;

import java.util.HashMap;

public class User {
    private UserId userId;
    private UserName userName;
    private UserEmail userEmail;
    private UserBalance userBalance;
    private UserIsSeller isSeller;
    private UserRating userRating;

    public User(UserId userId, UserName userName, UserEmail userEmail,UserBalance userBalance, UserIsSeller isSeller, UserRating userRating) {
        this.userId = userId;
        this.userName = userName;
        this.userBalance = userBalance;
        this.userEmail = userEmail;
        this.isSeller = isSeller;
        this.userRating = userRating;
    }

    public static User create(UserId userId, UserName userName, UserEmail userEmail)
    {
        //Se aplican las reglas de negocio:
        //Cuando se crean usuarios el balance es 0, no es vendedor y su rating es 5 estrellas
        User user = new User(
                userId,
                userName,
                userEmail,
                new UserBalance(0d),
                new UserIsSeller(false),
                new UserRating(5d));
        return user;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {
            {
                put("id", userId.value());
                put("name", userName.value());
                put("email", userEmail.value());
                put("isSeller", isSeller.value());
                put("balance", userBalance.value());
                put("rating", userRating.value());
            }
        };
        return data;
    }
    
}
