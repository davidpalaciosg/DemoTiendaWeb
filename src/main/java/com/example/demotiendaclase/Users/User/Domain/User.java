package com.example.demotiendaclase.Users.User.Domain;

import com.example.demotiendaclase.Users.User.Domain.Entities.UserAddress;
import com.example.demotiendaclase.Users.User.Domain.ValueObject.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {
    private UserId userId;
    private UserName userName;
    private UserEmail userEmail;
    private UserBalance userBalance;
    private UserIsSeller isSeller;
    private UserRating userRating;
    private UserPassword userPassword;

    private Optional<List<UserAddress>> addressList;

    //Cargar un objeto de la base de datos
    public User(UserId userId, UserName userName, UserEmail userEmail,UserBalance userBalance, UserIsSeller isSeller,
                UserRating userRating, UserPassword userPassword,
                Optional<List<UserAddress>> addressList) {
        this.userId = userId;
        this.userName = userName;
        this.userBalance = userBalance;
        this.userEmail = userEmail;
        this.isSeller = isSeller;
        this.userRating = userRating;
        this.userPassword = userPassword;
        this.addressList = addressList;
    }

    //Crear un objeto y cargarlo a la base de datos
    public static User create(UserId userId, UserName userName, UserEmail userEmail, UserPassword userPassword)
    {
        //Se aplican las reglas de negocio:
        //Cuando se crean usuarios el balance es 0, no es vendedor y su rating es 5 estrellas
        User user = new User(
                userId,
                userName,
                userEmail,
                new UserBalance(0d),
                new UserIsSeller(false),
                new UserRating(5d),
                userPassword,
                null);
        return user;
    }

    public void authenticateUser(UserEmail userEmail, UserPassword userPassword)
    {
        if(!(this.userPassword.equals(userPassword) && this.userEmail.equals(userEmail)))
        {
            throw new RuntimeException("Credenciales inválidas");
        }
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
                put("address",createAddress());
            }
        };
        return data;
    }

    private List<HashMap<String,Object>> createAddress(){
        List<HashMap<String,Object>> list = new ArrayList<>();
        if(!addressList.isEmpty()) {
            list= addressList.get().stream().map(address->address.data()).collect(Collectors.toList());
        }
        return list;
    }

}
