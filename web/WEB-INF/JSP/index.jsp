<jsp:useBean id="zaakvoerder" scope="request" type="be.vdab.entities.persoon"/>
<jsp:useBean id="begroeting" scope="request" type="be.vdab.entities.begroeting"/>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Pizza Luigi"/>
    </c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1>pizza Luigi</h1>
<img src="<c:url value="/images/pizza.jpg"/>" alt="Pizza" class="fullwidth">
<h2>${begroeting}</h2>
<h3>De zaakvoerder :</h3>
<dl>
    <dt>Naam</dt>
    <dd>${zaakvoerder.naam}</dd>
    <dt>Kinderen</dt>
    <dd>${zaakvoerder.kinderen}</dd>
    <dt>Gehuwd</dt>
    <dd>${zaakvoerder.gehuwd ? 'ja' : 'nee'}</dd>
    <dt>Adres</dt>
    <dd>${zaakvoerder.adres.straat} ${zaakvoerder.adres.huisnummer}</dd>
    <dd>${zaakvoerder.adres.postcode} ${zaakvoerder.adres.gemeente}</dd>
</dl>
</body>
</html>
