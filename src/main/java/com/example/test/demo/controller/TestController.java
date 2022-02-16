package com.example.test.demo.controller;

import com.example.test.demo.model.ClientDesjardins;
import com.example.test.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  private ClientService clientService;

  @GetMapping("/get/{id}")
  public ResponseEntity<ClientDesjardins> getClient(@RequestParam("id") Integer id) {
    ClientDesjardins clientDesjardins = clientService.clientAvecPrix(id);
    return ResponseEntity.ok(clientDesjardins);
  }
}