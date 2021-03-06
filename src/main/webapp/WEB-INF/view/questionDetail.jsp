<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>

    <title>Forum - Your Question</title>
    <link rel="stylesheet" type="text/css" href='<c:url value="/static/css/style.css"/>' />
    <link rel="stylesheet" type="text/css" href='<c:url value="/static/css/skin.css"/>'>

    <link rel="stylesheet" type="text/css" href='<c:url value="/static/css/questionDetail.css"/>' />
    <script src='<c:url value="/static/jsquery/jquery.js"/>'></script>

</head>


<body class="yui-skin-sam">

<div id="container">

    <div id="header">
        <%@ include file="registerHeader.jsp" %>
    </div>

    <div id="content">

        <div id ="leftPane" >

                <div id="left">
                    <div id="questionTitle">
                        <h1>${question.title}</h1>
                    </div>

                    <div id="questionDescription" >
                        <p>${question.description}</p>
                    </div>

                    <div id = "response">
                        <input id= "likeInput" type='submit' name="like" value="Like"></input>
                        <input id="dislikeInput" type='submit' name="dislike" value="Dislike"></input>
                        <input id="flagInput" type='submit' name="flag" value="Flag as Inappropriate"></input>
                    </div>

                    <div id ="tag">
                        <p><label class="questionDetail"> Tags:</label>
                        <c:forEach var="tag" items="${question.tags}">
                        <a href="<c:url value='/tags/${tag.value}'/>">${tag.value}</a>
                        </c:forEach>
                        </p>
                    </div>

                    <strong><label id="responses">Responses:</label></strong>
                    <br></br>
                    <div id="advice">
                        <c:forEach var="advice" items="${question.advices}">
                            <strong>${advice.user.username} </strong><br>
                            <font size=2 color="#045801">posted on
                            <fmt:formatDate value="${advice.createdAt}" pattern="dd-MM-yyyy" />
                            at
                            <fmt:formatDate value="${advice.createdAt}" pattern="hh:mm:ss a" />
                            </font>
                            <br><br>
                            ${advice.description}
                            <hr>
                        </c:forEach>
                    </div>

                    <div id="response2">
                        </br>


                        <sec:authorize access="isAnonymous()">
                            <!--<button type="button" id="loginAndPost" onclick='javascript:window.location="/forum/login?url="+window.location.href;'>Post advice</button>-->
                            <button type="button" id="loginAndPost" onclick='javascript:window.location="/forum/question/viewAndPost/${question.id}";'>Post advice</button>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <form:form method="post" action="../../postAdvice" commandName="advice" id="adviceForm">

                            <div class="adviceDescription" >
                                <label class="formLabels"> Advice: </label></br>
                                <form:textarea path="description" id="descriptionEditor" name="adviceDescription" rows="20" cols="75" maxlength="1000" />
                                <form:errors path="description" class="errorMsg" id="descriptionMsg" />
                                    <div class="validationMessage" id="descriptionValidationMessage">

                                    </div>
                                    <form:hidden path="questionId" id="questionId" value="${question.id}" />
                                </div>
                                <input type="submit" value="Submit" id="submitButton" />
                            </form:form>
                        </sec:authorize>
                    </div>
                </div>

                <div id="right">
                    <p><label class="questionDetail" id = "posted_by" name="user" > Posted by </label> ${question.user.username} </p>
                    <p><font color="045801"><label class="questionDetail" id = "posted_on" name="postedOn">On: </label>${dateCreatedAt} </p>
                    <p><label class="questionDetail" id = "posted_at" name="postedAt">At: </label>${timeCreatedAt}</font></p>
                    <p>
                    <label id="likeCount" class="questionDetail" name="likes">  (${question.likes}) Likes </label><br>
                    <label id="dislikeCount" class="questionDetail" name="dislikes">  (${question.dislikes}) Dislikes </label><br>
                    <label id="flagCount" class="questionDetail" name="flags">  (${question.flags}) Flags </label>
                    </p>
                </div>

        </div>

            <script src='<c:url value="/static/javascript/yahoo-dom-event.js"/>'></script>
            <script src='<c:url value="/static/javascript/jquery-latest.js"/>' type="text/javascript"></script>
            <script src='<c:url value="/static/javascript/jquery-events.js"/>' type="text/javascript"></script>

        <div id="rightPane">
                <%@ include file="rightPane.jsp" %>
        </div>
    </div>

    <script type="text/javascript">

    $('#likeInput').click(function(){
        updateCounter('#likeInput', 'like', '#likeCount')
    });

    $('#dislikeInput').click(function(){
        updateCounter('#dislikeInput', 'dislike', '#dislikeCount')
    });

    $('#flagInput').click(function(){
        updateCounter('#flagInput', 'flag', '#flagCount')
    });

    function updateCounter(inputElement, countType, countElement) {
        $.ajax({
            type: "POST",
            url: '<c:url value="/question/' + countType + '/${question.id}"/>',
            success: function(data){
                $(countElement).html(data);
            }
        }).done(function(){
            $(inputElement).attr("disabled", true);
        });
    }

    </script>
            <script type="text/javascript" src='<c:url value="/static/javascript/Advice.js"/>'></script>
            <script src='<c:url value="/static/javascript/element-min.js"/>'></script>
            <!-- Needed for Menus, Buttons and Overlays used in the Toolbar -->
            <script src='<c:url value="/static/javascript/container_core-min.js"/>'></script>
            <!-- Source file for Rich Text Editor-->
            <script src='<c:url value="/static/javascript/editor-min.js"/>'></script>
            <!---<script src='<c:url value="/static/javascript/simpleeditor-min.js"/>'></script> --->
            <script src='<c:url value="/static/javascript/postAdviceValidator.js"/>'></script>
</div>
</body>
</html>


