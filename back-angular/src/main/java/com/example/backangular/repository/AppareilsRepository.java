package com.example.backangular.repository;

import com.example.backangular.entity.Appareils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppareilsRepository extends JpaRepository<Appareils,Integer> {
}
