package com.example.contoller;


import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PersonList {


    @Autowired
    PersonRepository personRepository;


    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String getPersonList() {
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


    @RequestMapping(value = {"/editPerson"}, method = RequestMethod.GET)
    public String editPerson() {
        return "persons/editPerson";
    }

}
