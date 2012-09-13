<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<link rel="stylesheet" type="text/css" href='<c:url value="/static/css/style.css"/>'/>
<head>
    <title>Login</title>

    <script src='<c:url value="/static/jsquery/jquery.js"/>'></script>
    <script src='<c:url value="/static/javascript/knockout-2.1.0.js"/>'></script>
    <script src='http://connect.facebook.net/en_US/all.js'></script>
    <script src="<c:url value="/static/javascript/shareToSocialMedia.js"/>"></script>


</head>

<body>
<div id="container">
    <div id="header">
        <div class="topButtons">
            <ul id="topButtons">
                <li>
                    <div id="forumLinks">
                        <a href='<c:url value="/" />'> Home</a>
                    </div>
                </li>
            </ul>
        </div>

    </div>

    <div id="content">
        <div id="leftPane">
            <form name="loginForm" action="${pageContext.request.contextPath}/j_spring_security_check?url=${url}"
                  method="POST" autocomplete="off">
                <div style="color:red; text-align:center" id="messagetobedisplayed">
                    ${messageToBeDisplayed}
                </div>

                <table>
                    <tr>
                        <td>
                            <div id="noticeMessage">
                                <br> ${noticeMessage}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Username:
                        </td>
                    </tr>

                    <tr>
                        <td><input path="username" type="text" name="j_username" autocomplete="off" autofocus="on"/></td>
                        <div style="color:red; text-align:center" id="usernameError">
                            ${usernameError}
                        </div>
                        </td>

                    </tr>

                    <tr>
                        <td>Password:
                            <div style="color:red; text-align:center" id="passwordError">
                                ${passwordError}
                            </div>
                    </tr>
                    <tr>
                        <td><input path="password" type="password" name="j_password"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" name="submit"/></td>
                    </tr>


                    <tr>
                        <td>
                            <br>Not a registered user? <a href='<c:url value="/join" />'> Join us!</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <%@ include file="rightPane.jsp" %>
    </div>
</div>
</body>
</html>
