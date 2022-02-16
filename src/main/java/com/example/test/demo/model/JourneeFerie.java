package com.example.test.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum JourneeFerie {
  PAQUES("Chocolat", LocalDate.of(2020, 2, 9)),
  NOEL("ho-ho-ho", LocalDate.of(2020, 12, 25)),
  COMBATANTS("homage", LocalDate.of(2020, 11, 11));

  private final String prix;
  private final LocalDate dateFerie;

  public static Map<JourneeFerie, String> getList() {
    Map<JourneeFerie, String> list = new HashMap<>();
    for(JourneeFerie value : JourneeFerie.values()) {
      list.put(value, value.prix);
    }
    return list;
  }
}