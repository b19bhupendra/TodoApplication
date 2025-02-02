package com.app.todoapp.services;

import java.util.List;

import com.app.todoapp.models.Task;

public interface ITaskService {

	List getAllTasks();

	void createTask(String title);

	void deleteTask(Long id);

	void toggleTask(Long id);

	void updateTask(Long id,String task);

	Task getTaskById(Long id);

}
