package com;

import com.api.UserApi;
import com.dto.UserDto;
import com.dto.UserRequest;
import com.entity.User;
import com.mapping.UserMapping;
import com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserFacade implements UserApi {

    private final UserService userService;

    @Override
    public List<UserDto> getAllUser() {
        return userService.findAllUsers()
                .stream()
                .map(UserMapping::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findUser(Integer id) {
        final User userById = userService.findUserById(id);
        return UserMapping.mapUserToUserDto(userById);
    }

    @Override
    public UserDto saveUser(UserRequest userRequest) {
        User user = UserMapping.mapUserRequestToUser(userRequest);
        User savedUser = userService.save(user);
        return UserMapping.mapUserToUserDto(savedUser);
    }
}
