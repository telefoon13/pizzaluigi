<%@page contentType='text/html' pageEncoding='UTF-8' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<fmt:setBundle basename="teksten"/>
<!DOCTYPE html>
<html lang="nl">
<head>
    <vdab:head title="Pizza Luigi - Identificatie"/>
</head>
<body>
<c:import url="/WEB-INF/JSP/taalkiezen.jsp"/>
<vdab:menu/>
<h1><fmt:message key="identificatie" var="ide"/></h1>
<form method="post" name="identificatieForm">
    <label><fmt:message key="gebruikersnaam"/>(coockie) : <input name="gebruikersnaam" value="${gebruikersnaam}"
                                                                 autofocus></label>
    <label><fmt:message key="gebruikersnaam2"/>(session) : <input name="gebruikersnaam2" value="${gebruikersnaam2}"
                                                                  autofocus></label>
    <input type="submit" value="<fmt:message key="onthoudMe"/>">
</form>
</body>
</html>