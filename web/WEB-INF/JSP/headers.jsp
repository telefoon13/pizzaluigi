<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <vdab:head title="Pizza Luigi - Headers"/>
</head>
<body>
<vdab:menu/>
<h1>Headers</h1>

<dl>
    <dt>Browser</dt>
    <dd>${empty browser ? "Onbekend" : browser}</dd>
    <c:forEach var="h" items="${headers}">
        <dt>${h.key}</dt>
        <dd>${h.value}</dd>
    </c:forEach>
</dl>
</body>
</html>