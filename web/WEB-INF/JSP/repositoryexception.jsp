<%@page contentType='text/html' pageEncoding='UTF-8' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <vdab:head title="Pizza Luigi - 500"/>
</head>
<body>
<vdab:menu/>
<h1>Data fout (500)</h1>
<img src="../../images/datafout.jpg" alt="Data fout">
<p>Er is een data fout opgetreden in ons systeem gelieven de helpdesk te contacteren als dit probleem zich blijft
    voordoen.</p>
<div>Helpdesk : ${helpDeskTelefoon}</div>
</body>
</html>