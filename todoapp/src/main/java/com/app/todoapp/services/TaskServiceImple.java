package com.app.todoapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.todoapp.models.Task;
import com.app.todoapp.repository.ITaskRepository;

@Service
public class TaskServiceImple implements ITaskService {
	
	@Autowired
	private ITaskRepository taskRepository;
	
	/**
	 * 
	 */
   @Override
    public List<Task> getAllTasks() {
        // Use the repository to fetch all tasks
        return taskRepository.findAll();
    }

   /*
    * Service method to save the created task in the database
    */
	@Override
	public void createTask(String title) {
		// TODO Auto-generated method stub
		Task task = new Task();
		task.setTitle(title);
		task.setCompleted(false);
		//Now saving it to the database for that we need the repository
		taskRepository.save(task);
	}

	@Override
	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);
	}
	
	/*
	 * 
	 * task.setCompleted will set the value reverse to the current (to reverse we have used !)
	 * task.isCompleted will give the current value 
	 */
	@Override
	public void toggleTask(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Task id"));
		task.setCompleted(!task.isCompleted());
		taskRepository.save(task);
	}
}
