package com.mapping;


import com.dto.AccountDto;
import com.dto.AdresseDto;
import com.dto.UserDto;
import com.dto.UserRequest;
import com.entity.Account;
import com.entity.Adresse;
import com.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapping {


    public static UserDto mapUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setBooks(user.getBooks());

        Set<AccountDto> accountDtoSet = user.getAccounts().stream()
                .map(UserMapping::mapAccounToAccountDto)
                .collect(Collectors.toSet());

        userDto.setAccountDtos(accountDtoSet);

        userDto.setPassword(user.getPassword());

        userDto.setAdresseDto(mapAdresseToAdresseDto(user.getAdresse()));

        return userDto;

    }


    private static AccountDto mapAccounToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(account.getAccountNumber());
        return accountDto;
    }

    private static AdresseDto mapAdresseToAdresseDto(Adresse adresse) {
        AdresseDto adresseDto = new AdresseDto();
        adresseDto.setName(adresse.getName());
        adresseDto.setCodePostal(adresse.getCodePostal());
        return adresseDto;
    }

    public static User mapUserRequestToUser(UserRequest userRequest) {
        User user = new User();

        user.setFirstName(userRequest.getFirstname());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setBooks(userRequest.getBooks());

        Set<Account> accounts = userRequest.getAccountDtoSet().stream()
                .map(UserMapping::mapAccounDtoToAccount)
                .collect(Collectors.toSet());

        user.setAccounts(accounts);

        user.setPassword(userRequest.getPassword());

        user.setAdresse(mapAdresseDtoToAdresse(userRequest.getAdresseDto()));

        return user;
    }

    private static Adresse mapAdresseDtoToAdresse(AdresseDto adresseDto) {
        Adresse adresse = new Adresse();
        adresse.setName(adresseDto.getName());
        adresse.setCodePostal(adresseDto.getCodePostal());
        return adresse;
    }

    private static Account mapAccounDtoToAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        return account;
    }
}
