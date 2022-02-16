package com.example.test.demo.repository;

import com.example.test.demo.model.ClientDesjardins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientDesjardins, Integer> {
}