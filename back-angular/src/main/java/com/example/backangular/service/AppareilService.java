package com.example.backangular.service;

import java.util.List;

import com.example.backangular.entity.Appareils;
import com.example.backangular.repository.AppareilsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppareilService {

    private final AppareilsRepository appareilsRepository;

    public List<Appareils> getListAppareil() {
        return appareilsRepository.findAll();

    }

}
