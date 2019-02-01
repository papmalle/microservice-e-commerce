package com.controller;

import com.UserFacade;
import com.constante.UserConstants;
import com.dto.UserDto;
import com.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping(UserConstants.USER)
    List<UserDto> getAllUser() {
        return userFacade.getAllUser();
    }

    @GetMapping(UserConstants.USER_ID)
    UserDto findUser(@PathVariable() Integer id) {
        return userFacade.findUser(id);
    }

    @PostMapping(UserConstants.SAVE_USER)
    public UserDto saveUser(@RequestBody UserRequest userRequest) {

        return userFacade.saveUser(userRequest);
    }


}
