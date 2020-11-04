
<%@ page import="java.util.*,com.Witvoet.web.jdbc.*" %>
<html>
<head>
<title>Web Student TodoList</title>
</head>
<% List<ToDoList> thetodolist = (List<ToDoList>)request.getAttribute("TODOLIST_LIST"); %> 
<body>
<!-- ${TODOLIST_LIST}-->
<%= thetodolist %>
</body>
</html>