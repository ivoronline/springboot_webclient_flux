package com.ivoronline.springboot_webclient_flux.services;

import com.ivoronline.springboot_webclient_flux.entities.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;
import java.util.List;

@Component
public class PersonService {

  //===============================================================
  // GET PERSONS
  //===============================================================
  public void getPersons() {

    //GET PERSON FROM SERVER
    List<Person> persons = WebClient.create("http://localhost:8080")
                                .get()
                                .uri("/GetPersons")
                                .retrieve()
                                .bodyToFlux(Person.class)
                                .collectList()
                                .block(Duration.ofSeconds(3));

    //DISPLAY PERSONS
    System.out.println("getPersons()");
    for (Person person : persons) {
      System.out.println(person.id + " " + person.name+ " " + person.age);
    }

  }

}


