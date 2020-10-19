<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.Date" %>

<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <% Date date = new Date(); %>
    <h2>Привет</h2>
    <h2>Сегодня: <%= date %></h2>
  </body>
</html>
