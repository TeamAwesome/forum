<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

    <title>Forum - Your Question</title>
    <link rel="stylesheet" type="text/css" href='<c:url value="/static/css/questionDetail.css"/>' />
    <link rel="stylesheet" type="text/css" href='<c:url value="/static/css/style.css"/>' />

</head>

<body class="question">

<div id="container">

    <div id="header">
        <%@ include file="registerHeader.jsp" %>
    </div>

    <div id="content">

        <div id="rightPane">
            <%@ include file="rightPane.jsp" %>
        </div>

        <div id ="leftPane" >

                <div id="left">
                    <div id="questionTitle">
                        <h1>${questionTitle}</h1>
                    </div>

                    <div id="questionDescription" >
                        <p>${questionDescription}</p>
                    </div>

                    <div id = "response">
                        <button name="like">Like</button>
                        <button name="dislike">Dislike</button>
                        <button name="flag">Flag</button>
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
                    <label class="questionDetail" name="likes">  (${likes})Likes </label>
                    <label class="questionDetail" name="dislikes">  (${dislikes})Dislikes </label>
                    <label class="questionDetail" name="views">  (${views})Views </label>
                    <label class="questionDetail" name="responses">  (${responses})Responses </label>
                    <label class="questionDetail" name="flags">  (${flags})Flags </label>
                    </p>
                </div>

        </div>

    </div>

</div>


