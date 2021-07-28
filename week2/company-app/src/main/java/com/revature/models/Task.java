package com.revature.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable{

	private int id;
	private String name;
	private String description;
	private String completionStatus;
	private Employee assignedEmployee;
	private LocalDate assignDate;
	private LocalDate dueDate;
	
	public Task(String name) {
		super();
		this.name = name;
	}
	public Task(int id) {
		super();
		this.id = id;
	}
	public Task(int id, String name, String description, String completionStatus, Employee assignedEmployee,
			LocalDate assignDate, LocalDate dueDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.completionStatus = completionStatus;
		this.assignedEmployee = assignedEmployee;
		this.assignDate = assignDate;
		this.dueDate = dueDate;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompletionStatus() {
		return completionStatus;
	}
	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}
	public Employee getAssignedEmployee() {
		return assignedEmployee;
	}
	public void setAssignedEmployee(Employee assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}
	public LocalDate getAssignDate() {
		return assignDate;
	}
	public void setAssignDate(LocalDate assignDate) {
		this.assignDate = assignDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignDate == null) ? 0 : assignDate.hashCode());
		result = prime * result + ((assignedEmployee == null) ? 0 : assignedEmployee.hashCode());
		result = prime * result + ((completionStatus == null) ? 0 : completionStatus.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (assignDate == null) {
			if (other.assignDate != null)
				return false;
		} else if (!assignDate.equals(other.assignDate))
			return false;
		if (assignedEmployee == null) {
			if (other.assignedEmployee != null)
				return false;
		} else if (!assignedEmployee.equals(other.assignedEmployee))
			return false;
		if (completionStatus == null) {
			if (other.completionStatus != null)
				return false;
		} else if (!completionStatus.equals(other.completionStatus))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", completionStatus="
				+ completionStatus + ", assignedEmployee=" + assignedEmployee + ", assignDate=" + assignDate
				+ ", dueDate=" + dueDate + "]";
	}
	
	
}
