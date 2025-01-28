package com.app.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.ITaskService;


@Controller
@RequestMapping("/")
public class TaskController {
	
	@Autowired
	private ITaskService taskService;
	
	/*
	 * In model.addAtribute whatever we pass will be available in the view
	 */
	@GetMapping("getTasks")
	public String getTasks(Model model) {
		
		List<Task> tasks = taskService.getAllTasks();
		
		model.addAttribute("tasks",tasks);
		
		return "tasks";
	}
	
	/*
	 * @Method : Adding the task 
	 * @Params : RequestParam because data will be coming form the post request
	 * @Return : Redirect to the listing page.
	 * After adding to update the list we have used redirect:/getTasks
	 */
	
	@PostMapping("createTask")
	public String createTask(@RequestParam String title) {
		
		taskService.createTask(title);
		//Once the task is created the we have to make sure that task list is updated.
		//for that we need to add the redirect:/
		return "redirect:/getTasks";
	}

	/*
	 * Method: to remove the task
	 * @Params: PathVaribale because we are accepting id in path(url) and pathVaribale tells to look id inot the path
	 */

	@GetMapping("/{id}/remove")
	public String deleteTask(@PathVariable Long id) {
		
		taskService.deleteTask(id);
		return "redirect:/getTasks";
	}
	
	
	/*
	 * Method : End-point for toggling the status
	 */
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Long id) {
		taskService.toggleTask(id);
		return "redirect:/getTasks";
	}
}





