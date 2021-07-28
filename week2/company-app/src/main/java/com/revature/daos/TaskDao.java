package com.revature.daos;

import java.util.List;

import com.revature.models.Task;

public interface TaskDao {
	public abstract Task getTaskById(int id);
	public abstract List<Task> getTasks();
	public abstract int addTask(Task task); // return id assigned
	public abstract boolean updateTask(Task task);
	public abstract int deleteTask(int id);
	public abstract List<Task> getTaskByEmployeeId(int id);
}
