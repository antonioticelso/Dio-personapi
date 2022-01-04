package com.github.antonioelso.personapi.repository;

import com.github.antonioelso.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
