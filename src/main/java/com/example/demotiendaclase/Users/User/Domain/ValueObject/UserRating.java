package com.example.demotiendaclase.Users.User.Domain.ValueObject;

import com.example.demotiendaclase.Shared.Domain.Aggregate.BooleanValueObject;
import com.example.demotiendaclase.Shared.Domain.Aggregate.DoubleValueObject;

public class UserRating extends DoubleValueObject {
    public UserRating(double value){
        validate(value);
        this.value = value;
    }

    private void validate(double value) {
        validateStars(value);
    }

    private void validateStars(double value) {
        if(value<1 || value >5){
            throw new RuntimeException("Rating no valido");
        }
    }
}
