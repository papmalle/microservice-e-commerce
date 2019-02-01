package com.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Set<AccountDto> accountDtos;

    private AdresseDto adresseDto;

    private List<String> books;
}
