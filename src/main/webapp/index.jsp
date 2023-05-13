<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<h2>Emploi du temps</h2>
<h1><%= "Hello World!" %>
</h1>
<h1> Student Registration Page</h1>
<h1> Student Registration Page</h1>
<form action="<%= request.getContextPath() %>/StudentServlet" method="post">

    Horraire: <input type="text" name="scheduled">
    <br> <br>
Professeur :<input type="text" name="prof">
    <br> <br>

    Matiere: <input type="text" name="matiereProf">
    <br> <br>

    jour: <input type="text" name="jour">
    <br> <br>

    <input type="submit" value="register">
</form>

<form action="<%= request.getContextPath() %>/UpdateServelet" method="post">
    Id: <input type="text" name="id">
    <br> <br>
    Horraire: <input type="text" name="scheduled">
    <br> <br>
    Professeur :<input type="text" name="prof">
    <br> <br>

    Matiere: <input type="text" name="matiereProf">
    <br> <br>

    jour: <input type="text" name="jour">
    <br> <br>

    <input type="submit" value="register">
</form>

<form action="<%= request.getContextPath() %>/DeleteServelet" method="post">
    Id: <input type="text" name="id">
    <br> <br>
    <input type="submit" value="register">
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>

</div>
</body>
</html>