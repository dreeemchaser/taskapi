package com.taskapi.service;

import com.taskapi.model.Task;
import com.taskapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    /*
        ALl the logic for CRUD lives here.
     */
    @Autowired
    private TaskRepository taskRepository;

    // GetALl Tasks:
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // GetTaskByID:
    public Optional<Task> getTaskByID(Long ID){
        return taskRepository.findById(ID);
    }

    // CreateTask:
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    // UpdateTask:
    public Task updateTask(Long taskID,Task taskDetails){
        return taskRepository.findById(taskID)
                .map(existingTask -> {
                    existingTask.setTitle(taskDetails.getTitle());
                    existingTask.setDescription(taskDetails.getDescription());
                    existingTask.setModifiedAt(LocalDateTime.now());
                    return taskRepository.save(existingTask);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Task not found. ID: %d", taskID)));
    }

    // DeleteTask:
    public void deleteTask(Long taskID){
        if(taskRepository.existsById(taskID)){
            taskRepository.deleteById(taskID);
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Task not found. ID: %d", taskID));
    }
}
