package com.example.backangular.controller;

import java.util.List;

import com.example.backangular.entity.Appareils;
import com.example.backangular.service.AppareilService;
import com.mproduits.api.ProductsApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppareilController {
    private final ProductsApi productsApi;


    private final AppareilService appareilService;

//    @CrossOrigin(origins = "*")
    @GetMapping("/appareils")
    public List<Appareils> getAppareils() {

        Appareils appareils = new Appareils();
        appareils.setId(6);
        appareils.setName(productsApi.getProducts().get(1).getDescription());
        appareils.setStatus("eteint");

        appareilService.getListAppareil().add(appareils);

        return appareilService.getListAppareil();
    }
}

