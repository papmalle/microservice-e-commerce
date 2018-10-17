package com.mproduits.constant;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductApiConstant {
    public static final String SERVICE_NAME = "products-service"; // pour le ribbon (loadbalancer)

    public static final String PATH_PRODUCT = "/products";
    public static final String PATH_PRODUCT_BY_ID = PATH_PRODUCT + "/";
    public static final String ID_PRODUCT = "idProduct";
}
