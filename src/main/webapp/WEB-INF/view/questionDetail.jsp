<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

    <title>Forum - Your Question</title>
    <link rel="stylesheet" type="text/css" href='<c:url value="/static/css/style.css"/>' />
    <link rel="stylesheet" type="text/css" href='<c:url value="/static/css/questionDetail.css"/>' />
    <link rel="stylesheet" type="text/css" href='<c:url value="/static/css/style.css"/>' />
    <script src='<c:url value="/static/jsquery/jquery.js"/>'></script>

</head>


<body class="question">

<div id="container">

    <div id="header">
        <%@ include file="registerHeader.jsp" %>
    </div>

    <div id="content">
        <div id ="leftPane" >

                <div id="left">
                    <div id="questionTitle">
                        <h1>${questionTitle}</h1>
                    </div>

                    <div id="questionDescription" >
                        <p>${questionDescription}</p>
                    </div>

                    <div id = "response">
                        <input id= "likeInput" type='submit' name="like" value="Like"></input>
                        <input id="dislikeInput" type='submit' name="dislike" value="Dislike"></input>
                        <input id="flagInput" type='submit' name="flag" value="Flags"></input>
                        <p><label class="questionDetail" name="tags"> Tags:</label> ${questionTags} </p>
                        <p><label>Your Reply: </label></p>
                        <textarea id="replyTextarea" cols="40" rows="14" ></textarea>
                        <p><button name="submitReply">Submit</button><p>
                    </div>
                </div>

                <div id="right">
                    <p><label class="questionDetail" id = "posted_by" name="user" > Posted by </label> ${username} </p>
                    <p><label class="questionDetail" id = "posted_on" name="postedOn">On: </label>${dateCreatedAt} </p>
                    <p><label class="questionDetail" id = "posted_at" name="postedOn">At: </label>${timeCreatedAt}</p>
                    <p>
                    <label id="likeCount" class="questionDetail" name="likes">  (${likes}) Likes </label>
                    <label id="dislikeCount" class="questionDetail" name="dislikes">  (${dislikes}) Dislikes </label>
                    <label class="questionDetail" name="views">  (${views})Views </label>
                    <label class="questionDetail" name="responses">  (${responses})Responses </label>
                    <label id="flagCount" class="questionDetail" name="flags">  (${flags}) Flags </label>
                    </p>
                </div>

        </div>

        <div id="rightPane">
                <%@ include file="rightPane.jsp" %>
        </div>
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
        url: '<c:url value="/question/' + countType + '/${questionId}"/>',
        success: function(data){
            $(countElement).html(data);
        },
    }).done(function(){
        $(inputElement).attr("disabled", true);
    });
}

</script>