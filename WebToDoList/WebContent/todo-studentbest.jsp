<!DOCTYPE html>
<%@ page import="java.util.*,com.Witvoet.web.jdbc.*" %>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
<link href="./main.css" rel="stylesheet" />
<title>Web Student ToDoList</title>
<link type="text/css" rel="stylesheet" href="css/mystyle.css">
</head>
<% List<ToDoList> thetodolist = (List<ToDoList>)request.getAttribute("TODOLIST_LIST"); %> 
<body>
<div class="v1_17">
<div class="name">

</div><div class="name">
</div><div class="name">
</div><div id="container"> <div id="content">
<table> <tr>
                   <th>Title</th>
                   <th>Content</th>
</tr>
<% for(ToDoList temptodo:thetodolist) { %>
	<tr>
	<td><%= temptodo.getTitle() %></td> 
	<td><%= temptodo.getContent() %></td>
             <%} %>
      </table>
</div>
</div>
<div class="name">
</div><div class="name">
</div><div class="name">
</div><div class="logout-button">
</div>
<span class="v1_45">Logout</span>
</body>
</html>