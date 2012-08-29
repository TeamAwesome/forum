<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css"/>">
    <script src='http://connect.facebook.net/en_US/all.js'></script>
    <script src="<c:url value="/static/javascript/shareToSocialMedia.js"/>"></script>
    <script src="<c:url value="/static/jsquery/jquery.js"/>"></script>
    <script src="<c:url value="/static/javascript/knockout-2.1.0.js"/>"></script>
</head>

<body>

 <div id="container">
        <div id="header">
            <%@ include file="registerHeader.jsp" %>
        </div>

    <div id="content">
        <div id ="leftPane" >
            <div id="activityWallTitle">
                <h1>Activity Wall</h1>
            </div>

            <div id="activityQuestions" >
                      <p id="QuestionParagraph" data-bind="foreach: questions">
                      <table>
                      <tr>
                      <td width=105px>
                      <font color="#599425">Statistics</font>
                          <br>
                          <font class="small">
                              0 Likes
                              <hr class="dottedLine">
                              0 Dislikes
                              <hr class="dottedLine">
                              0 Views
                              <hr class="dottedLine">
                              0 Responses
                              <hr class="dottedLine">
                              0 Flags
                              <br><br>
                          </font>

                      </td>
                      <td width=350px><a data-bind="attr: {href: url }"><b>
                      <span class="questionTitle" data-bind="text: title"> </span></b>
                      </a>
                      &nbsp;-&nbsp;
                      <br />
                     <span class="questionDescription" data-bind="html: description"
                      style='width: 350px; height: 1em; overflow: hidden; display: inline-block; font-size:.8em;'>
                       </span>...
                      <br><font color="#599425" size="2em">Created on:</font><br>
                                            <span class="questionCreatedAt" data-bind="text: createdAt" style="font-size:.7em;"> </span>
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
        </div>

        <div id="rightPane">
            <%@ include file="rightPane.jsp" %>
        </div>

    </div>

</div>


</body>
</html>

