package com.Witvoet.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ToDoStudentServlet
 */
@WebServlet("/ToDoStudentServlet")
public class ToDoStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ListDBUtil listDbUtil;
	
	@Resource(name="jdbc/JavaProject")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		listDbUtil = new ListDBUtil(dataSource);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		try {
			listToDo(request,response);
			} catch (Exception e) {
			// TODO Auto-generated catch block e.printStackTrace();
			}
	}
	private void listToDo(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
			List<ToDoList> todolists = listDbUtil.getStudents(); 
			request.setAttribute("TODOLIST_LIST", todolists);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/todo-studentbest.jsp"); 
			dispatcher.forward(request, response);
			}



}
