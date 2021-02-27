package com.example.contoller;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@Controller
public class Tasks {

    // wstrzyknięcie poprzez konstruktor
    private final PersonService personService;
    public Tasks(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = {"/tasks"}, method = RequestMethod.GET)
    public String getTasks() {
        return "tasks/tasks";
    }

    @RequestMapping(value = {"/addTask"}, method = RequestMethod.GET)
    public String getAddTasks(Model model) {
        List<Person> list = personService.getPersonList();
        model.addAttribute("person", list);
        return "tasks/addTask";
    }

    @RequestMapping(value = {"/addTask/{person_id}"}, method = RequestMethod.POST)
    public RedirectView postAddTasks(Model model) {
        List<Person> list = personService.getPersonList();
        model.addAttribute("person", list);
        return new RedirectView("/tasks");
    }



}
