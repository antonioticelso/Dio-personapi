package com.github.antonioelso.personapi.service;

import com.github.antonioelso.personapi.dto.request.PersonDTO;
import com.github.antonioelso.personapi.dto.response.MessageResponseDTO;
import com.github.antonioelso.personapi.entity.Person;
import com.github.antonioelso.personapi.repository.PersonRepository;
import com.github.antonioelso.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person person = PersonUtils.createFakeEntity();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(person);
        MessageResponseDTO expected = createExpectedMessageResponse(person.getId());

        MessageResponseDTO messageResponseDTO = personService.createPerson(personDTO);

        Assertions.assertEquals(expected, messageResponseDTO);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO.builder().message("Created person with ID " + id).build();
    }
}
