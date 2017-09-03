<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <vdab:head title="Pizza Luigi - Statistieken"/>
</head>
<body>
<vdab:menu/>
<h1>Statistieken</h1>
<dl>
    <dt>Welkom</dt>
    <dd>${indexRequests}</dd>
    <dt>Pizza's lijst</dt>
    <dd>${pizzaRequests}</dd>
    <dt>Pizza's Detail</dt>
    <dd>${pizzaDetailRequests}</dd>
    <dt>Statistieken</dt>
    <dd>${statistiekRequests}</dd>
    <dt>Tussen prijzen</dt>
    <dd>${pizzasTussenPrijzenRequests}</dd>
    <dt>Voorkeur Pizza's</dt>
    <dd>${voorkeurPizzasRequests}</dd>
    <dt>Pizza toevoegen</dt>
    <dd>${pizzaToevoegenRequests}</dd>
    <dt>Headers</dt>
    <dd>${headersRequests}</dd>
    <dt>Identificatie</dt>
    <dd>${identificatieRequests}</dd>
    <dt></dt>
    <dd></dd>
    <dt>Aantal mandjes</dt>
    <dd>${aantalMandjes}</dd>
</dl>
</body>
</html>