package com.example.demotiendaclase.Users.User.Domain.ValueObject;

import com.example.demotiendaclase.Shared.Domain.Aggregate.CustomUUID;

public class UserId extends CustomUUID {

    public UserId(String value) {
        super(value);
    }
}
