package com.example.contoller;

import com.example.model.Person;
import com.example.model.Task;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@Controller
public class Tasks {

    // wstrzyknięcie poprzez konstruktor
    private final PersonService personService;
    private final TaskService taskService;
    public Tasks(PersonService personService, TaskService taskService) {
        this.personService = personService;
        this.taskService = taskService;
    }

    @RequestMapping(value = {"/tasks"}, method = RequestMethod.GET)
    public String getTasks(Model model) {
        List<Task> taskList = taskService.getTaskList();
        model.addAttribute("task", taskList);
        return "tasks/tasks";
    }

    @RequestMapping(value = {"/addTask"}, method = RequestMethod.GET)
    public String getAddTasks(Model model) {
        List<Person> list = personService.getPersonList();
        model.addAttribute("person", list);
        return "tasks/addTask";
    }

    @RequestMapping(value = {"/addNewTask"}, method = RequestMethod.POST)
    public RedirectView saveAddTask(@ModelAttribute Task newTask) {
        taskService.saveTask(newTask);
        return new RedirectView("/tasks");
    }

    @RequestMapping(value = {"/editTask/{id}"}, method = RequestMethod.GET)
    public String getEditTasks(Model model, @PathVariable String id) {
        model.addAttribute("task", taskService.getTask(Long.parseLong(id)));
        return "tasks/editTask";
    }

    @RequestMapping(value = {"/tasks/{id}/{person_id}"}, method = RequestMethod.POST)
    public RedirectView postEditSaveTasks(@ModelAttribute Task newTask, @PathVariable String person_id) {
        taskService.editTask(newTask, personService.getPerson(Long.parseLong(person_id)));
        return new RedirectView("/tasks");

    }


}
