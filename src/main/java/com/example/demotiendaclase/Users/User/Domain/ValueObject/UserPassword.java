package com.example.demotiendaclase.Users.User.Domain.ValueObject;

import com.example.demotiendaclase.Shared.Domain.Aggregate.StringValueObject;

public class UserPassword extends StringValueObject {
    public UserPassword(String value){
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        necesaryChars(value);
    }

    private void necesaryChars(String value){
        if(!value.contains("$") || !value.contains("*"))
        {
            throw new RuntimeException("Contraseña no valida");
        }
    }
}
