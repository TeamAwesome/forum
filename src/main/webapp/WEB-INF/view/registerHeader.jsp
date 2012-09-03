<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" type="text/css" href='<c:url value="/static/css/style.css"/>'>
<div class="topButtons">
    <div id="forumLinks">
        <ul>
            <li id="joinButton">
            <a href='<c:url value="/" />' Value="Home" > Home</a>
            </li>
            <sec:authorize access="isAnonymous()">
                &nbsp;
                <li id="loginLink">
                    <a href='<c:url value="/login" />' Value="Log In" > Login</a>
                </li>&nbsp;
                <li id="joinLink">
                    <a href='<c:url value="/join" />' Value="Join"> Join</a>&nbsp;
                </li>&nbsp;
            </sec:authorize>
            <li id="postQuestionLink">
                <a href='<c:url value="/postQuestion" />' Value="Post Question"> Post Question</a>&nbsp;
            </li>&nbsp;
            <sec:authorize access="isAuthenticated()">
                <li id="logoutLink">
                    <a name="logout" id="logout" href="<c:url value='j_spring_security_logout' />">Logout</a>
                </li>
            </sec:authorize>
        </ul>
        </div>
        <div id="searchBar">
            <input type="text" name="search" value=""  accesskey="f" id="searchInput" tabindex="1" placeholder="Search" autocomplete="on">
            <button type="submit" name="button" title="Search Wikipedia for this text"
            id="searchButton" width="12" height="13">
            <img src='<c:url value="/static/images/search.png"/>' width="12" height="13" alt="Search"></button>
        </div>
</div>



