package com.duscas.example.api;

public class PersonNotFoundException extends RuntimeException{
    PersonNotFoundException(String cpf) {
        super("Could not find person " + cpf);
    }
}
