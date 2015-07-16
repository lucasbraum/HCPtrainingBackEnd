package com.sap.task.tracker.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sap.task.tracker.dao.TaskDAO;
import com.sap.task.tracker.model.Task;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskDAO taskDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Task> findAll() {
		return taskDao.getAllTasks();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Task findById(@PathVariable long id) {
		return taskDao.getTaskById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Task create(@RequestBody Task task) {
		return taskDao.createTask(task);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		taskDao.deleteTask(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Task setOccupied(@PathVariable long id, @RequestBody Task task) {
		return taskDao.updateTask(id, task);
	}

}
