<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="user" class="example.User" />
    <% user.setName(request.getParameter("name")); %>
    <h2>Привет: <%= user.getName() %></h2>
</body>
</html>
