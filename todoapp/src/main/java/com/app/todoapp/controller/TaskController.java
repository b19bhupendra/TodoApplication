package com.app.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.ITaskService;


@Controller
@RequestMapping("/")
public class TaskController {
	
	@Autowired
	private ITaskService taskService;
	
	@GetMapping
	public String getTasks(Model model) {
		
		List<Task> tasks = taskService.getAllTasks();
		
		model.addAttribute("tasks",tasks);
		
		return "tasks";
	}
	

}
