package com.api;

import com.constante.UserConstants;
import com.dto.UserDto;
import com.dto.UserRequest;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;


@FeignClient(UserConstants.USER_MICROSERVICE)
public interface UserApi {

    @RequestLine("GET " +UserConstants.USER )
    List<UserDto> getAllUser();
    @RequestLine("GET "+ UserConstants.USER_ID)
    UserDto findUser(@Param("id") Integer id);

    @RequestLine("POST "+ UserConstants.SAVE_USER)
    UserDto saveUser(UserRequest userRequest);


}
