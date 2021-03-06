<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<link rel="stylesheet" type="text/css" href='<c:url value="/static/css/style.css"/>'/>

<head>
    <title>${title}</title>

    <script src='<c:url value="/static/jsquery/jquery.js"/>'></script>
    <script src='<c:url value="/static/javascript/knockout-2.1.0.js"/>'></script>
    <c:if test="${empty title}">
        <script src='https://connect.facebook.net/en_US/all.js'></script>
        <script src='<c:url value="/static/javascript/shareToSocialMedia.js"/>'></script>
    </c:if>

</head>

<body>

 <div id="container" >
        <div id="header">
            <%@ include file="registerHeader.jsp" %>
        </div>

    <div id="content">
        <div id ="leftPane" >
            <div id="activityWallTitle">
            <c:if test="${empty tagName}">
                <h1 class="activityWall">Activity Wall</h1>
            </c:if>
            <c:if test="${not empty tagName}">
                <h1 class="activityWall">Questions with tag ${tagName}</h1>
            </c:if>
            </div>

            <div id="activityQuestions" >
                      <p id="QuestionParagraph" data-bind="foreach: questions">
                      <table class = "userTable">
                      <tr>
                      <td width=10%>
                      <font size = 3 color="#599425">Statistics<br /></font>
                      <ul id="likes">
                          <li>
                           <span class="questionlikes" data-bind="text: likes"
                                style=' height: 1em;  font-size:.75em;'>
                           </span><font size = 1em>&nbsp;Likes<br /></font>
                          </li>
                           <li>
                           <span class="questiondislikes" data-bind="text: dislikes"
                               style=' height: 1em;  font-size:.75em;'>
                          </span><font size = 1>&nbsp;Dislikes<br /></font>
                          </li>
                          <li>
                          <span class="questionflags" data-bind="text: flags"
                             style=' height: 1em;  font-size:.75em;'>
                          </span><font size = 1>&nbsp;Flags<br /></font>
                          </li>
                      </ul>
                      </td>
                      <td width=60%>
                      <a data-bind="attr:{href:url}"><b>

                      <span class="questionTitle" data-bind="html: title" style='width: 350px; height: 1.3em;overflow: hidden; display: inline-block;'> </span></b>
                       </a>
                      &nbsp;-&nbsp;
                      <br />
                     <span class="questionDescription" data-bind="html: description"
                      style='width: 350px; height: 1.2em; overflow: hidden; display: inline-block; font-size:.8em;'>
                       </span>...
                      <br /><font color="#599425" size="2em">Created on:</font><br />
                      <span class="questionCreatedAt" data-bind="text: createdAt" style="font-size:.7em;"> </span>
                      </td>

                    <td width=10% class = "image">
                    <img src='<c:url value="/static/images/empty_profile_picture.gif"/>' width=60 height=60>

                    <br />
                    <span id="questionUserID" data-bind="text: userName">
                    <img src='<c:url value="/static/images/empty_profile_picture.gif"/>' width=100 height=100> </span>
                    <br />
                     </td>
                     </tr>
                     </table>
                </p>

                <button id="loadMoreQuestions" data-bind="click: loadMoreQuestion">more..</button>
                <script src='<c:url value="/static/javascript/moreQuestionsLoader.js"/>'></script>
                <br /><br />
            </div>
        </div>

        <div id ="rightPane">
         <%@ include file="rightPane.jsp" %>
        <p>
        <center>
          <c:if test="${empty title}">
          <a onclick='postToFeed(); return false;'><img style="cursor: pointer; cursor: hand"
          src="<c:url value='static/images/facebook.png'/>" alt="Facebook" class="Facebook Icon"></a>
          <a href="https://twitter.com/share" data-url=window.location.href
          data-text="Need info on Bangalore?" data-size="large" data-count="none" target="_blank">
          <img src="<c:url value='static/images/twitter.png'/>" alt="Twitter" style="border-style: none"></a>
          </c:if>
          </center>
          </p>
         </div>

    </div>

</div>


</body>
</html>

