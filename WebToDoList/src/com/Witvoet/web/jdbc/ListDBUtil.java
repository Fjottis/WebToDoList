package com.Witvoet.web.jdbc;

 

import java.sql.Connection;
import java.sql.PreparedStatement;
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

 

    public List<ToDoList> getList() throws Exception { 
        List<ToDoList> todolists= new ArrayList<ToDoList>();
        Connection myConn=null; 
        Statement myStmt = null;
        ResultSet myRs= null; 
        try {
            myConn = dataSource.getConnection();
            myStmt= myConn.createStatement();
            String sql= "select * from JavaProject.List order by Listid"; 
            myRs = myStmt.executeQuery(sql);
            while(myRs.next()){
            	int id = myRs.getInt("Listid");
                String title=myRs.getString("title"); 
                String content=myRs.getString("content"); 
                ToDoList temptodolist= new ToDoList(title,content,id); 
                todolists.add(temptodolist);
            }
            return todolists; 
        } 
        finally{
            close(myConn,myStmt,myRs);
        }
    }
    
    public void addToDo(String title,String content) throws Exception{
        Connection myConn=null;
        PreparedStatement myStmt = null;
        try {
            myConn = dataSource.getConnection();
            String sql= "INSERT INTO List (title,content) VALUES (?,?)";
            myStmt= myConn.prepareStatement(sql);
            myStmt.setString(1,title);
            myStmt.setString(2,content);
            myStmt.execute();
        } finally{
        close(myConn,myStmt,null);
        }
    }
    public Boolean isUser(String username,String password)throws Exception{
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null; 
        Boolean bool= false;
        try {
            myConn = dataSource.getConnection();
            String sql= "select count(*) from user where username=? and password=?";
            myStmt= myConn.prepareStatement(sql);
            myStmt.setString(1,username);
            myStmt.setString(2,password);
            myRs = myStmt.executeQuery(sql);
            if (myRs.getInt("count(*)")==1)
            {
                bool=true;
            }
            return bool; 
        } finally{
        close(myConn,myStmt,null);
        }
    }
    public Boolean isTeacher(String username,String password)throws Exception{
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null; 
        Boolean bool= false;
        try {
            myConn = dataSource.getConnection();
            String sql= "select isTeacher from user where username=? and password=?";
            myStmt= myConn.prepareStatement(sql);
            myStmt.setString(1,username);
            myStmt.setString(2,password);
            myRs = myStmt.executeQuery(sql);
            if (myRs.getInt("isteacher")==1)
            {
                bool=true;
            }
            return bool; 
        } finally{
        close(myConn,myStmt,null);
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
    public ToDoList fetchToDo(int listid) { 
    	Connection myConn=null;
    	Statement myStmt = null; 
    	ResultSet myRs= null; 
    	ToDoList todo=null;
    	try {
    			myConn = dataSource.getConnection();
    			myStmt= myConn.createStatement();
    			String sql= "select * from List where Listid="+listid; 
    			myRs = myStmt.executeQuery(sql);
    			while(myRs.next()){
    				String title=myRs.getString("title"); 
    				String content=myRs.getString("content"); 
    				todo = new ToDoList(title,content); 
    			}
    			return todo; 
    	}
    	catch(Exception e){
    			System.out.println(e.getMessage());
    			return null; 
    	}
    	finally{
                close(myConn,myStmt,myRs);
        }
    }



	public void updateToDoList(ToDoList todo) {
		// TODO Auto-generated method stub
		Connection myConn=null;
		PreparedStatement myStmt = null; 
		try {
			myConn = dataSource.getConnection();
			String sql = "update student set first_name=?, last_name=?,email=? where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, todo.getTitle()); 
			myStmt.setString(2, todo.getContent());  
			myStmt.setInt(4,todo.getId()); 
			myStmt.execute();
		}
		catch(Exception e){
			System.out.println(e.getMessage()); 
		}
		finally{ 
			close(myConn,myStmt,null);
		}
	}
}
 