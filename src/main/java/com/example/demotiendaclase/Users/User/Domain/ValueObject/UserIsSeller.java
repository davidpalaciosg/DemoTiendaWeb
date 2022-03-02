package com.example.demotiendaclase.Users.User.Domain.ValueObject;

import com.example.demotiendaclase.Shared.Domain.Aggregate.BooleanValueObject;

public class UserIsSeller extends BooleanValueObject {
    public UserIsSeller(Boolean value){
        this.value = value;
    }
}
