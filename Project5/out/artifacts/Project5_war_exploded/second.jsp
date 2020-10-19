<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.Date" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <% Date date1 = new Date(); %>
        <%! Date date2 = new Date(); %>
        <h3> date1: <%= date1 %></h3>
        <h3> date2: <%= date2 %></h3>
    </body>
</html>
