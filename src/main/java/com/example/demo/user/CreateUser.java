package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Tutaj nie ma numeru ID. Ważne jest, żeby numer ID był unikalny dla każdego użytkownika
public class CreateUser {
    private String name;
    private String surname;
}
