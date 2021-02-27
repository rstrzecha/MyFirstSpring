package com.example.service;


import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    // wstrzyknięcie poprzez konstruktor
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    // findAll service
    public List<Person> getPersonList(){
        return personRepository.findAll();
    }


    // findById service
    public Person getPerson(Long id){
        return personRepository.findById(id).orElse(null);
    }

   // deleteById service
    public void deletePerson(Long id){
        personRepository.deleteById(id);
        System.out.println("deleting person on id:" + id);
    }

    // save/edit person service
    public void editPerson(Person person, Long id){
        Person editPerson = new Person(
          id,
          person.getFirstName(),
          person.getLastName(),
          person.getGitHub(),
          person.getStart(),
          person.getJava(),
          person.getBestPractice(),
          person.getTdd(),
          person.getQuestion(),
          person.getHibernate(),
          person.getHtml(),
          person.getJsp(),
          person.getThymeleaf(),
          person.getGit(),
          person.getCheckbox()
        );

        personRepository.save(editPerson);
        System.out.println("editing person on id:" + id);
    }


}
