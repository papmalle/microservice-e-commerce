package com.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserRequest {
    private String firstname;
    private String lastName;
    private String password;
    private String email;
    private List<String> books;

   private AdresseDto adresseDto;

    private Set<AccountDto> accountDtoSet;

}
