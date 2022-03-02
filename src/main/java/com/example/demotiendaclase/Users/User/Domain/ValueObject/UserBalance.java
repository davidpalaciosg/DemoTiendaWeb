package com.example.demotiendaclase.Users.User.Domain.ValueObject;

import com.example.demotiendaclase.Shared.Domain.Aggregate.DoubleValueObject;

public class UserBalance extends DoubleValueObject {
    public UserBalance(double value){
        validate(value);
        this.value = value;
    }

    private void validate(double value) {
        notNegative(value);
    }

    private void notNegative(double value) {
        if(value<0){
            throw new RuntimeException("Balance negativo");
        }
    }
}
