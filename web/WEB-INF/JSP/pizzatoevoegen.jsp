<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <vdab:head title="Pizza Luigi - Pizza toevoegen"/>
</head>
<body>
<vdab:menu/>
<h1>Pizza toevoegen</h1>
<form method="post" id="toevoegform" enctype="multipart/form-data">
    <label>naam<span>${fouten.naam}</span>
        <input name="naam" value="${param.naam}" autofocus required></label>
    <label>Prijs<span>${fouten.prijs}</span>
        <input name="prijs" value="${param.prijs}" required type="number" min="0" max="100" step="0.01"></label>
    <div><label><input type="checkbox" name="pikant" value="pikant">Pikant ?</label></div>
    <label>Foto<span>${fouten.foto}</span>
        <input type="file" name="foto"></label>
    <input type="submit" value="Toevoegen !" id="toevoegknop">
</form>

<script language="JavaScript">
    document.getElementById("toevoegform").onsubmit = function () {
        document.getElementById("toevoegknop").disabled = true;
    }
</script>
</body>
</html>