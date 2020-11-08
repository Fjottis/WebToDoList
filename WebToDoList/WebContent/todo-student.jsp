<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Web Student Tracker</title>
<link type="text/css" rel="stylesheet" href="css/style.css"> </head>
<body>
<!-- ${STUDENT_LIST}-->
<div id="wrapper">
<div id="header">
<h2>ESILV Engineer School</h2>
      </div>
</div>
<div id="container"> <div id="content">
<table> <tr>
<th>Title </th>
<th>Content</th>
</tr>
<c:forEach var="tempTodo" items="${TODOLIST_LIST }" > <tr>
	<c:url var="EditLink" value= "EditToDoServlet">
	<c:param name="ToDoId" value="${tempRodo.title}"/> 
	</c:url>
	<tr>
		<td> ${tempTodo.title}</td>
		<td> ${tempTodo.content}</td>
		<td> <a href="${EditLink }"> Edit</a></td>
    </tr>
              </c:forEach>
      </table>
</div>
</div>
</body>
</html>