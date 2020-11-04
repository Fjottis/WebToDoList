package com.Witvoet.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ListDBUtil {
	
	private DataSource dataSource;

	public ListDBUtil(DataSource TheDataSource) {
		// TODO Auto-generated constructor stub
		dataSource = TheDataSource;
	}

	public List<ToDoList> getStudents() throws Exception { 
		List<ToDoList> todolists= new ArrayList<ToDoList>();
		Connection myConn=null; 
		Statement myStmt = null;
		ResultSet myRs= null; 
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from JavaProject.List order by title"; 
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
				String title=myRs.getString("title"); 
				String content=myRs.getString("content"); 
				ToDoList temptodolist= new ToDoList(title,content); 
				todolists.add(temptodolist);
			}
			return todolists; 
		} 
		finally{
	        close(myConn,myStmt,myRs);
	    }
	}
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try{
			if(myStmt!=null)
				myStmt.close(); 
			if(myRs!=null)
				myRs.close(); 
			if(myConn!=null)
				myConn.close(); }
		catch(Exception e){
			System.out.println(e.getMessage()); 
		}
	}
}
