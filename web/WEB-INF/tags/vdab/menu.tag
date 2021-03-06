<%@tag description='menu' pageEncoding='UTF-8' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<header>
    <nav>
        <ul>
            <li><a href="<c:url value="/"/>">Welkom</a></li>
            <li><a href="<c:url value="/pizzas.htm"/>">Pizza's</a></li>
            <li><a href="<c:url value="/statistiek.htm"/>">Statistiek</a></li>
            <li><a href="<c:url value="/pizzas/tussenprijzen.htm"/>">Pizza's tussen prijzen</a></li>
            <li><a href="<c:url value="/pizzas/voorkeuren.htm"/>">Voorkeur pizza's</a></li>
            <li><a href="<c:url value="/pizzas/toevoegen.htm"/>">Pizza toevoegen</a></li>
            <li><a href="<c:url value="/headers.htm"/>">Header</a></li>
            <li><a href="<c:url value="/identificatie.htm"/>">Indentificatie</a></li>
            <li><a href="<c:url value="/pizzas/bestellen.htm"/>">Bestellen</a></li>
        </ul>
    </nav>
</header>