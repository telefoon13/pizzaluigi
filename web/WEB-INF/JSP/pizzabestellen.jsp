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
<h1>Pizza bestellen</h1>
<c:if test="${not empty pizzas}">
    <h2>Assortiment</h2>
    <form method="post" id="toevoegForm">
        <ul class="zonderbolletjes">
            <c:forEach var="pizza" items="${pizzas}">
                <li>
                    <label><input type="checkbox" name="id" value="${pizza.id}">
                        <c:out value="${pizza.naam}"/></label>
                </li>
            </c:forEach>
        </ul>
        <input type="submit" value="Toevoegen aan mandje" id="toevoegKnop">
    </form>
</c:if>
<c:if test="${not empty pizzasInMandje}">
    <h2>Jouw mandje</h2>
    <ul>
        <c:forEach var="pizza" items="${pizzasInMandje}">
            <li><c:out value="${pizza.naam}"/></li>
        </c:forEach>
    </ul>
</c:if>
<script language="JavaScript">
    //Wanneer het FORM word gesubmit
    document.getElementById('toevoegForm').onsubmit = function () {
        //Als cookies uitstaan
        if (!(navigator.cookieEnabled)) {
            alert("Je kan enkel je mandje vullen als je cookies aanvaard");
            return false;
        }
        //De toevoegknop uitschakelen (dubbel submit vermijden)
        document.getElementById('toevoegKnop').disable = true;
    };
</script>
</body>
</html>