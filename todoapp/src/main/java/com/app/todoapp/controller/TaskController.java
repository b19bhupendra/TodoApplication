package com.app.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.todoapp.services.ITaskService;


@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private ITaskService taskService;
	
	@GetMapping("/getTasks")
	public String getTasks(Model model) {
		
		List<> tasks = taskService.getAllTasks();
		
		model.addAttribute("tasks",tasks);
		
		return "tasks";
	}
	

}
