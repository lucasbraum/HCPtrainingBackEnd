package com.sap.task.tracker.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sap.task.tracker.model.Task;

@Repository
public class TaskDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<Task> getAllTasks(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Task> criteria = cb.createQuery(Task.class);
		Collection<Task> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public Task getTaskById(long id){
		Task task = em.find(Task.class, id);
		return task;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public Task createTask(Task task){
		em.persist(task);
		return task;
	}
	
	@Transactional
	public void deleteTask(long id) {
		Task task = getTaskById(id);

		if (task != null) {
			em.remove(task);
		}
	}
	
	@Transactional
	public Task updateTask(long id, Task newTask){
		Task task = getTaskById(id);
		
		task.setName(newTask.getName());
		task.setDone(newTask.isDone());
		
		em.merge(task);
		return task;
	}

}
