package com.github.antonioelso.personapi.service;

import com.github.antonioelso.personapi.dto.response.MessageResponseDTO;
import com.github.antonioelso.personapi.entity.Person;
import com.github.antonioelso.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson( Person person) {
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savePerson.getId())
                .build();
    }

}
