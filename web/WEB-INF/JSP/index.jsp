<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Pizza Luigi - HomePage"/>
</head>
<body>
<vdab:menu/>
<h1>Pizza Luigi
    <c:forEach begin="1" end="5">
        &#9733;
    </c:forEach> pizza's</h1>
<img src="<c:url value="/images/pizza.jpg"/>" alt="Pizza" class="fullwidth">
<h2>${begroeting}</h2>
<fmt:parseDate value="${nu}" pattern="yyyy-MM-dd" var="nuAlsDate" type="date"/>
<p>Het is vandaag <fmt:formatDate value="${nuAlsDate}"/></p>
<dl>
    <dt>Aantal pizza's verkocht</dt>
    <dd><fmt:formatNumber value="${aantalPizzasVerkocht}" type="NUMBER"/></dd>
</dl>
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
<footer style="text-align: center">
    <div>Helpdesk : ${helpDeskTelefoon}</div>
</footer>
</body>
</html>
