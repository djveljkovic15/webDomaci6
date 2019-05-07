<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.Asistent" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
<title>Primer sa JavaBeans</title>
</head>
<body>

<%

    ArrayList<Asistent> asistenti = (ArrayList<Asistent>)request.getAttribute("data");
    pageContext.setAttribute("asses", asistenti);

%>

<ul>
  <c:forEach var="ass"
             items="${asses}">
    <li><c:out value="${ass.ime}"/>
      <c:out value="${ass.prosecnaOcena}"/>
      [ukupna ocena(<c:out value="${ass.ukupnaOcena}"/>)
      broj ocena(<c:out value="${ass.brojOcena}"/>)]</li>
  </c:forEach>
</ul>
<%--<c:if test="${empty requestScope.list}">--%>
<c:if test="${empty asses}">
    Lista je prazna
</c:if>

  <%--<c:choose>--%>
    <%--<c:when test="${asses}">--%>
      <%--pizza.--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
      <%--forsaan--%>
    <%--</c:otherwise>--%>
  <%--</c:choose>--%>


<%--<a href="index.jsp">Pocetna strana</a>--%>

</body>
</html>
