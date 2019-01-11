package com.example.backangular.service;

import java.util.Comparator;
import java.util.List;

import com.example.backangular.entity.Appareils;
import com.example.backangular.repository.AppareilsRepository;
import com.mproduits.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppareilService {

    private final AppareilsRepository appareilsRepository;
    private final ProductService productService;

    public List<Appareils> getListAppareil() {
        ProductResponse productResponse = productService.getAppareilProduct().stream()
                .findFirst().get();

        Appareils appareil = new Appareils();
        appareil.setStatus("eteint");
        appareil.setName(productResponse.getDescription());
        appareil.setId(6);

        List<Appareils> appareilsList = appareilsRepository.findAll();
        appareilsList.add(appareil);
        return appareilsList;

    }


    public Appareils getListAppareilIdMax() {
        return appareilsRepository.findAll().stream()
                .max(Comparator.comparing(Appareils::getId))
                .orElseThrow(IllegalArgumentException::new);
    }

}
