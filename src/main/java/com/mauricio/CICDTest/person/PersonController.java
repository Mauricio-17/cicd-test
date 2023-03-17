package com.mauricio.CICDTest.person;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<PersonEntity> getPeople(){
        return personService.getPeople();
    }

    @PostMapping
    public PersonEntity createPerson(@RequestBody PersonDto personDto){
        return personService.createPerson(personDto);
    }
}
