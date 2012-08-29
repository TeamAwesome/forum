<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css"/>">
    <script src='http://connect.facebook.net/en_US/all.js'></script>
    <script src="<c:url value="/static/jsquery/jquery.js"/>"></script>
    <script src="<c:url value="/static/javascript/knockout-2.1.0.js"/>"></script>
</head>

<body class="home">
<center>
<table>
    <tr>
    <td align="center">
        <div id="title">
            <%@ include file="registerHeader.jsp" %>
            <div id="logo"><img class="logo" src="<c:url value="/static/images/forum.jpg"/>"></div>
        </div>
    </td>
    </tr>

    <tr>
    <td>
    <div id="main">
        <div class ="activityWall" >
            <div id="activityWallTitle">
                <h1>Activity Wall</h1>
            </div>

            <div id="activityQuestions" >
                      <p id="QuestionParagraph" data-bind="foreach: questions">
                      <table>
                      <tr><td width=100px>
                      <br><font color="brown">Status</font>
                      <br>0 likes
                      <br>0 Flags</td>
                      <td width=400px><a data-bind="attr: {href: url }"><i><b>
                      <span id="questionTitle" data-bind="text: title"> </span></i></b>
                      </a>
                      &nbsp;-&nbsp;
                      <br />
                     <span id="questionDescription" data-bind="html: description"
                      style='width: 500px; height: 1em; overflow: hidden; display: inline-block'> </span>...
                      <br><i><font color="brown">Created on:</font></i><br>
                                            <span id="questionCreatedAt" data-bind="text: createdAt"> </span>
                      </td>

                      <td>
                    <img src="<c:url value="/static/images/empty_profile_picture.gif"/>" width=60 height=60>

                    <br />UserId
                    <span id="questionUserID" data-bind="text: userId">
                    <img src="<c:url value="/static/images/empty_profile_picture.gif"/>" width=100 height=100> </span>
                    <br />
                     </td>
                     </tr>
                     </table>
                </p>

                <button id="loadMoreQuestions" data-bind="click: loadMoreQuestion">more..</button>
                <script src="<c:url value="/static/javascript/moreQuestionsLoader.js"/>"></script>
                <br /><br />
        </div>
    </td>

    <td>
        <div class="rightPane">
            <div id="tagCloud">
                <img src="<c:url value="/static/images/tag_cloud.png"/>">
            </div>
            <div id="advertisement">ADVERTISEMENT</div>
            <div id='fb-root'>
                <p id='msg'></p>
                <p>
                    <a onclick='postToFeed(); return false;'><img style="cursor: pointer; cursor: hand" src="<c:url value="static/CLEditor1_3_0/images/facebookShare.png"/>" alt="Facebook" class="Facebook Icon" height="50" width="50"></a>
                    <a href="https://twitter.com/share" class="twitter-share-button" data-url="http://10.10.5.107:8080/forum/" data-text="Need info on Bangalore?" data-size="large" data-count="none">Tweet</a>
                </p>
            </div>
        </div>
    </td>
    </div>
    </td>
    </tr>
</table>

</center>
    <script src="<c:url value="/static/javascript/shareToSocialMedia.js"/>"></script>
</body>
</html>

