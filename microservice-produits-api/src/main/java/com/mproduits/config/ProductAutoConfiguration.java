package com.mproduits.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mproduits") // afin de me scanner les composant spring dans mon app client
public class ProductAutoConfiguration {
}
