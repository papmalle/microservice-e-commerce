package com.products;

import com.mproduits.api.ProductsApi;
import com.mproduits.config.ProductConfiguration;
import com.mproduits.dto.ProductResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductConfiguration.class)
@DataJpaTest

public class ProductTests {

    @Autowired
    ProductsApi productsApi;


    @Test

    public void test(){
        final List<ProductResponse> products = productsApi.getProducts();
        Assert.assertEquals(products.size(),8);
    }
}
