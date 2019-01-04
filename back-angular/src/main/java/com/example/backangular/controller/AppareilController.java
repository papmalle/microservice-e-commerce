package com.example.backangular.controller;

import java.util.List;

import com.example.backangular.entity.Appareils;
import com.example.backangular.service.AppareilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppareilController {

    private final AppareilService appareilService;

//    @CrossOrigin(origins = "*")
    @GetMapping("/appareils")
    public List<Appareils> getAppareils() {
        return appareilService.getListAppareil();
    }
}

