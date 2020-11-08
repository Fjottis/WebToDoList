package com.Witvoet.web.jdbc;

public class ToDoList {

	String title;
	String content;
	int id ;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id= id;
	}
	
	public ToDoList(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	public ToDoList(String title, String content,int id) {
		super();
		this.title = title;
		this.content = content;
		this.id=id;
	}
	@Override
	public String toString() {
		return "ToDoList : title=" + title + ", content=" + content + "]";
	}
	
}
