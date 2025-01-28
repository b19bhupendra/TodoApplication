package com.app.todoapp.services;

import java.util.List;

public interface ITaskService {

	List getAllTasks();

	void createTask(String title);

	void deleteTask(Long id);

	void toggleTask(Long id);

}
