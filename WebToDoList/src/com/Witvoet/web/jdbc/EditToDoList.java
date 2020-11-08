package com.Witvoet.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EditToDoList
 */
@WebServlet("/EditToDoList")
public class EditToDoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ListDBUtil listDbUtil;
	@Resource(name="jdbc/JavaProject") 
	private DataSource dataSource;
	int id;
	
	@Override
	public void init() throws ServletException { 
		super.init();
		listDbUtil = new ListDBUtil(dataSource); 
	}
	
    public EditToDoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id=Integer.parseInt(request.getParameter("ToDoId"));
		ToDoList todo= listDbUtil.fetchToDo(id); 
		request.setAttribute("ToDoList", todo); 
		request.getRequestDispatcher("edit-todolist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title= request.getParameter("title"); 
		String content= request.getParameter("content"); 
		ToDoList todo = new ToDoList(title,content); 
		listDbUtil.updateToDoList(todo); 
		response.sendRedirect("ToDoStudentServlet");
		}

}
