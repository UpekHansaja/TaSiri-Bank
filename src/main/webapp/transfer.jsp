<%--
  Created by IntelliJ IDEA.
  User: upekhansaja
  Date: 2026-10-12
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer | TaSiri Bank</title>
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

<form action="transfer" method="post">

    <label for="receiver">Receiver's Account Number</label>
    <input type="text" id="receiver" name="receiverAccNo" placeholder="xxxx-xxxx-xxxx-xxxx" required>

    <label for="amount">Amount</label>
    <input type="number" step="any" id="amount" name="amount" placeholder="100.00" required>

    <button type="submit">Transfer Money</button>

</form>

</body>
</html>
