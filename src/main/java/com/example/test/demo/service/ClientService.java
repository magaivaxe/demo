package com.example.test.demo.service;

import com.example.test.demo.model.ClientDesjardins;
import com.example.test.demo.model.JourneeFerie;
import com.example.test.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public ClientDesjardins clientAvecPrix(Integer id) {
    ClientDesjardins clientDesjardins = clientRepository.getById(id);
    Map<JourneeFerie, String> prixParJourneeFerie = getPrixList();
    return checkFerieClient(clientDesjardins, prixParJourneeFerie);
  }

  private ClientDesjardins checkFerieClient(ClientDesjardins clientDesjardins,
                                            Map<JourneeFerie, String> list) {
    for (JourneeFerie journeeFerie : list.keySet()) {
      if (JourneeFerie.NOEL.getDateFerie().getDayOfYear() == LocalDate.now().getDayOfYear()) {
        clientDesjardins.setPrix(journeeFerie.getPrix());
        clientRepository.save(clientDesjardins);
        continue;
      }
      if (JourneeFerie.COMBATANTS.getDateFerie().getDayOfYear() == LocalDate.now().getDayOfYear()) {
        clientDesjardins.setPrix(journeeFerie.getPrix());
        clientRepository.save(clientDesjardins);
        break;
      }
    }
    return clientDesjardins;
  }

  private Map<JourneeFerie, String> getPrixList() {
    return JourneeFerie.getList();
  }
}