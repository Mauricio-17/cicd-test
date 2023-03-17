package com.mauricio.CICDTest.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<PersonEntity> getPeople(){
        return personRepository.findAll();
    }

    public PersonEntity createPerson(PersonDto personDto){
        PersonEntity newPerson = new PersonEntity();
        newPerson.setDni(personDto.getDni());
        newPerson.setName(personDto.getName());
        newPerson.setLastName(personDto.getLastName());

        return personRepository.save(newPerson);
    }



}
