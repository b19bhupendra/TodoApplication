package com.app.todoapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todoapp.models.Task;
import com.app.todoapp.repository.ITaskRepository;

@Service
public class TaskServiceImple implements ITaskService {
	
	
	private ITaskRepository taskRepository;
	
   @Override
    public List<Task> getAllTasks() {
        // Use the repository to fetch all tasks
        return taskRepository.findAll();
    }

}
