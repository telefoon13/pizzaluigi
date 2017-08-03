<%--
  Created by IntelliJ IDEA.
  User: miked
  Date: 2/08/2017
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDateTime" %>
<html>
<head>
    <title>Pizza Luigi</title>
</head>
<body>
<h1>
    <%
        int uur = LocalDateTime.now().getHour();
        out.print(uur >= 6 && uur < 12 ? "Goede morgen deze morgen" : uur >= 12 && uur < 18 ? "Goede middag" : "Goede avond");
    %>
</h1>
</body>
</html>
