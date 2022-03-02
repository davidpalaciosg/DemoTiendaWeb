package com.example.demotiendaclase.Users.User.Domain.ValueObject;

import com.example.demotiendaclase.Shared.Domain.Aggregate.StringValueObject;

public class UserName extends StringValueObject {
    public UserName(String value){
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        lengthName(value);
    }

    private void lengthName(String value){
        if(value.length()<5 || value.length()>30)
        {
            throw new RuntimeException("Longitud del nombre no disponible");
        }
    }

}
