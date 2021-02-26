package com.ivoronline.springboot_webclient_flux.runners;

import com.ivoronline.springboot_webclient_flux.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

  @Autowired private PersonService personService;

  @Override
  public void run(String... args) throws Exception {
    personService.getPerson();
    personService.getPersons();
  }

}

