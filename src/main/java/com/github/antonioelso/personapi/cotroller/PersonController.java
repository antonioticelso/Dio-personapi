package com.github.antonioelso.personapi.cotroller;

import com.github.antonioelso.personapi.dto.response.MessageResponseDTO;
import com.github.antonioelso.personapi.entity.Person;
import com.github.antonioelso.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savePerson.getId())
                .build();
    }

}
