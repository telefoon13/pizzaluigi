<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="nl">
<head>
    <title>Pizza Luigi</title>
    <link rel="icon" href="../../images/favicon.ico">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="../../styles/default.css">
</head>
<body>
<h1>pizza Luigi</h1>
<img src="../../images/pizza.jpg" alt="Pizza" class="fullwidth">
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
