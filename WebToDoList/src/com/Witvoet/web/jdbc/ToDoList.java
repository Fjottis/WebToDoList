package com.Witvoet.web.jdbc;

public class ToDoList {

	String title;
	String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public ToDoList(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ToDoList : title=" + title + ", content=" + content + "]";
	}
	
}
