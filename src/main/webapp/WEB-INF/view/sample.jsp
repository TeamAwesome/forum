<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body class="home">
<c:choose>
<c:when test="${not empty connectionLinks}">
<div class="title">
    <span>Recent Connections</span>
</div>
<ul>
    <c:forEach var="link" items="${connectionLinks}">
    <li><a href="${servletPath}${link.key}" class="connection"><c:out value="${util:capitalizeAllWords(link.value)}" /></a></li>
    </c:forEach>
</ul>
</c:when>
<c:otherwise>
<div class="title">
    <span>No Recent Connections</span>
</div>
</c:otherwise>
</c:choose>
</body>
</html>
