<%@ page import="lk.jiat.bank.model.User" %>
<%@ page import="lk.jiat.bank.model.Account" %><%--
  Created by IntelliJ IDEA.
  User: upekhansaja
  Date: 2026-10-12
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard | TaSiri Bank</title>
</head>
<body>

<%

    User user = (User) session.getAttribute("loggedUser");

    Account account = (Account) request.getAttribute("userAccount");

%>

<h1>User Dashboard</h1>

<hr/>

<h2>
    Welcome <%= user.getUsername() %>
</h2>

<h3>
    Your Account No: <%= user.getAccNo() %>
</h3>

<h3>
    Your Account Balance: <%= account.getAccountBalance() %>
</h3>

<hr/>

<a href="<%= request.getContextPath() %>/transfer">Transfer Money</a>

<br>

<a href="<%= request.getContextPath() %>/logout">Logout</a>

</body>
</html>
