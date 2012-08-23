<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Welcome</title>
    <meta property="og:title" content="The Forum" />
    <meta property="og:type" content="city" />
    <meta property="og:url" content="http://localhost:8080/app/" />
    <meta property="og:image" content="" />
    <meta property="og:site_name" content="The Forum" />
    <meta property="fb:app_id" content="126401650838612" />
    <script src='http://connect.facebook.net/en_US/all.js'></script>
    <script src="<c:url value="/static/javascript/shareToSocialMedia.js"/>"></script>
</head>
<body class="home">
<%@ include file="registerHeader.jsp" %>

<div class="title">
    <span><h1>The Forum</h1></span>
</div>
<div class="activityWall" style="width:500px; height:750px; border:1px solid black;">
    <c:forEach items="${questions}" var="question">
        <p>
         <c:out value="${question.title}"/>
         <c:out value="${question.createdAt}" />
         </br>
         <c:out value="${question.description}" />
         </br>
         <c:out value="${question.user}" />
        </p>
    </c:forEach>
</div>

    <div id='fb-root'></div>
    <p id='msg'></p>

<p style="cursor:hand"><a onclick='postToFeed(); return false;'><img src="<c:url value="static/CLEditor1_3_0/images/facebookShare.jpg"/>" alt="Facebook" class="Facebook Icon" height="50" width="50"></a></p>

<p><a href="https://twitter.com/share" class="twitter-share-button" data-text="Visit the forum for info on Bangalore -&gt; http://localhost:8080/app" data-size="large" data-count="none">Tweet</a></p>

</body>
</html>

