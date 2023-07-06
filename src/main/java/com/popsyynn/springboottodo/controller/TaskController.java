package com.popsyynn.springboottodo.controller;

import com.popsyynn.springboottodo.entity.Task;
import com.popsyynn.springboottodo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    //add task to the database
    @PostMapping("/save")
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
        taskRepository.save(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //fetch all tasks
    @GetMapping("/get")
    public ResponseEntity<List<Task>> getAll(){
        List<Task> tasks = taskRepository.findAll();
        return new ResponseEntity<>(tasks,HttpStatus.OK);
    }

    //get Task by id
    @GetMapping("get/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) throws Exception {
        if (taskRepository.existsById(id)){
            throw new Exception("Id not found");
        }
        Task task = taskRepository.findById(id).orElseThrow(()->
                new Exception("id not found"));
        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    //update a task a task
    @PutMapping("update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id , @RequestBody Task task) throws Exception {
        Task task1 = taskRepository.findById(id).orElseThrow(()->
                new Exception("id not found"));
        task1.setTitle(task.getTitle());
        task1.setDescription(task.getDescription());
        task1.setCompleted(task.getCompleted());
        Task task2 = taskRepository.save(task1);

        return new ResponseEntity<>(task2 , HttpStatus.OK);
    }

    //delete a task by id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Task> deleteById(@PathVariable Long id) throws Exception {
        if (!taskRepository.existsById(id)){
            throw new Exception("id not found");
        }
        taskRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
