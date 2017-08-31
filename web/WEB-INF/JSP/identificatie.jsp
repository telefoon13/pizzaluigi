<%@page contentType='text/html' pageEncoding='UTF-8' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<fmt:setBundle basename="teksten"/>
<!DOCTYPE html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Pizza Luigi"/>
    </c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/taalkiezen.jsp"/>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1><fmt:message key="identificatie"/></h1>
<form method="post" name="identificatieForm">
    <label><fmt:message key="gebruikersnaam"/>(coockie) : <input name="gebruikersnaam" value="${gebruikersnaam}"
                                                                 autofocus></label>
    <label><fmt:message key="gebruikersnaam2"/>(session) : <input name="gebruikersnaam2" value="${gebruikersnaam2}"
                                                                  autofocus></label>
    <input type="submit" value="<fmt:message key="onthoudMe"/>">
</form>
</body>
</html>