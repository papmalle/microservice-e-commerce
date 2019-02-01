package com.constante;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConstants {
    public final static String USER = "/user";
    public final static String USER_ID = "/user/{id}";
    public final static String SAVE_USER = "/user/save";
    public static final String USER_MICROSERVICE = "user-microservice";
}
