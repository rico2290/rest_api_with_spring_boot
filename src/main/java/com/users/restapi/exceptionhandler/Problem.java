package com.users.restapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problem {
	
	private Integer stauts;
	private LocalDateTime dateHour;
	private String title;
	private List<FieldProblem> fieldProblem;
	
	
	public static class FieldProblem {
		
		private String name;
		private String message;
		
		public FieldProblem(String name, String message) {
			super();
			this.name = name;
			this.message = message;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
	
	
	public Integer getStauts() {
		return stauts;
	}
	public void setStauts(Integer stauts) {
		this.stauts = stauts;
	}
	public LocalDateTime getDateHour() {
		return dateHour;
	}
	public void setDateHour(LocalDateTime dateHour) {
		this.dateHour = dateHour;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<FieldProblem> getFieldProblem() {
		return fieldProblem;
	}
	public void setFieldProblem(List<FieldProblem> fieldProblem) {
		this.fieldProblem = fieldProblem;
	}
	
	

}
