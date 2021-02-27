package com.example.contoller;


import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class PersonList {

    // wstrzyknięcie poprzez konstruktor
    private final PersonService personService;

    public PersonList(PersonService personService) {
        this.personService = personService;
    }

    // wstrzyknięcie do pola
    @Autowired
    PersonRepository personRepository;

    // get all persons
    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String getPersonList(Model model) {
        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);
        return "persons/personList";
    }

    //only get view for add new person
    @RequestMapping(value = {"/addNewPerson"}, method = RequestMethod.GET)
    public String addNewPerson() {
        return "persons/addNewPerson";
    }

    // save person in database
    @RequestMapping(value = {"/addNewPerson"}, method = RequestMethod.POST)
    public RedirectView postSavePerson(@ModelAttribute Person newPerson) {
        personRepository.save(newPerson);
        return new RedirectView("/personList");
    }

    // get person for only edit view
    @RequestMapping(value = {"/editPerson/{id}"}, method = RequestMethod.GET)
    public String getEditPerson(Model model, @PathVariable String id) {
        model.addAttribute("person", personService.getPerson(Long.parseLong(id)));
        return "persons/editPerson";
    }

    // save/edit person
    @RequestMapping(value = {"/personList/{id}"}, method = RequestMethod.POST)
    public RedirectView postEditPerson(@ModelAttribute Person newPerson, @PathVariable String id) {
        personService.editPerson(newPerson, Long.parseLong(id));
        return new RedirectView("/editPerson/{id}");
    }


}
