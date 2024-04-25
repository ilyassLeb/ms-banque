<%@page import="web.CreditModel"%>
<%
CreditModel model =(CreditModel)request.getAttribute("creditModel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="webapp/css/style.css"/>
<title>Credit bancaire </title>

</head>
<body>
  <div>
    <form action="calculerMensualite.do" method="post">
    <table>
      <tr>
        <td>Montant </td>
        <td><input type="text" name="montant" value="<%=model.getMontant()%>"></td>
        <td>DH</td>
        </tr>
        <tr>
        <td>Taux </td>
        <td><input type="text" name="taux" value="<%=model.getTaux()%>"></td>
        <td>%</td>
        </tr>
        <tr>
        <td>Durée </td>
        <td><input type="text" name="duree" value="<%=model.getDuree()%>"></td>
        <td>mois</td>
      </tr>
    </table>
    <button type="submit">Calculer</button>
    </form>
  </div>
  <p></p>
  <div class="ds">
  Mensualité =<%=model.getMensualite()%>
  
  </div>
  
</body>
</html>