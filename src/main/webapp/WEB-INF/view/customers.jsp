<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <ul>
            <c:forEach var="customer" items="${customerList}">
            <li>
                ID: <c:out value="${customer.id}"/>,
                Name: <c:out value="${customer.firstName}"/> <c:out value="${customer.lastName}"/>
            </li>
            </c:forEach>
        </ul>
    </body>
</html>