<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" type="text/css" href='<c:url value="/static/css/style.css"/>'>
<div class="topButtons">
    <div name="forumLinks">
        <ul  id="topButtons">
            <li id="homeButton">
            <a href='<c:url value="/" />'> Home</a>
            </li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li id="adminButton">
                            <a href='<c:url value="/adminDashboard" />'> Dashboard</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li id="loginLink">
                    <a href='<c:url value="/login?url=" />'> Login</a>&nbsp;
                </li>
                <li id="joinLink">
                    <a href='<c:url value="/join" />'> Join</a>&nbsp;
                </li>
            </sec:authorize>
            <li id="postQuestionLink">
                <a href='<c:url value="/postQuestion" />'> Post Question</a>&nbsp;
            </li>
            <sec:authorize access="isAuthenticated()">
                <li id="logoutLink">
                    <a name="logout" id="logout" href="<c:url value='/forum_logout' />">Logout</a>
                </li>
            </sec:authorize>
        </ul>
        </div>
        <div id="loggedUser">
            <sec:authorize access="isAuthenticated()">
                Welcome: <strong><sec:authentication property="principal" /></strong>
            </sec:authorize>
        </div>

</div>



