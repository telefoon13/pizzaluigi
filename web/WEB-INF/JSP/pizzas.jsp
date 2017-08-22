<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Pizza Luigi"/>
    </c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1>Pizza's
    <c:forEach begin="1" end="5">
        &#9733;
    </c:forEach>
</h1>
<ul class="zebra">
    <c:forEach var="pizza" items="${pizzas}">
        <li>
            <div class="pizzalijstSmall">
                <c:choose>
                    <c:when test="${pizzaIdsMetFoto.contains(pizza.id)}">
                        <img src="../../pizzafotos/${pizza.id}.jpg" border="0" alt="${pizza.naam}" width="25"
                             height="25">
                    </c:when>
                    <c:otherwise>
                        <img src="../../pizzafotos/no-image.jpg" border="0" alt="No image" width="25" height="25">
                    </c:otherwise>
                </c:choose>
            </div>

            <c:choose>
                <c:when test="${pizza.pikant}">
                    <div class="pizzalijstPikant"><c:out value="${pizza.naam}"/></div>
                    <div class="pizzalijstSmall"><img src="../../images/chili.png" width="25" height="25"></div>
                </c:when>
                <c:otherwise>
                    <div class="pizzalijst"><c:out value="${pizza.naam}"/></div>
                </c:otherwise>
            </c:choose>

            <div class="pizzalijstSmall">€${pizza.prijs}</div>

            <c:url value="pizzas/detail.htm" var="detailURL">
                <c:param name="id" value="${pizza.id}"/>
            </c:url>
            <div class="pizzalijstSmall"><a href="${detailURL}"><img src="../../images/detail.png" border="0"
                                                                     alt="Details"></a></div>
        </li>
    </c:forEach>
</ul>
</body>
</html>