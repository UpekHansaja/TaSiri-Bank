<%--
  Created by IntelliJ IDEA.
  User: upekhansaja
  Date: 2026-10-12
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login | TaSiri Bank</title>
</head>
<body>

<%
    String error = (String) request.getAttribute("error");

    if (error != null) {
%>

<p style="color: red; font-size: 18px">
    <%= error %>
</p>

<%
    }
%>

<form action="login" method="post">

    <label for="username">Username</label>
    <input type="text" id="username" name="username" placeholder="Enter your username here." required>

    <label for="password">Password</label>
    <input type="password" id="password" name="password" placeholder="Enter your password here." required>

    <button type="submit">Login</button>

</form>

</body>
</html>
