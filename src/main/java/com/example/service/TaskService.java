package com.example.service;

import com.example.model.Person;
import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
//    private final PersonService personService;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // findAll service
    public List<Task> getTaskList()
    {
        return taskRepository.findAll();
    }


    // findById service
    public Task getTask(Long id){

        return taskRepository.findById(id).orElse(null);
    }

    // deleteById service
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
        System.out.println("deleting person on id:" + id);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public void editTask(Task task, Person person) {
        Task editedTask = new Task(
                task.getId(),
                task.getDeadline(),
                task.getDescription(),
                task.getColor(),
                task.getCreationDate(),
//                task.getPerson()
                person
        );
        taskRepository.save(editedTask);
    }


}
