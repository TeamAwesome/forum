<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forum - Your Question</title>
</head>
<body class="question">
<div class="title">
    <h2>${questionTitle}</h2>
    <div class="question">

        <p><label class="questionDetail" name="title"> Title: </label>${questionTitle}  </p>
        <p><label class="questionDetail" name="description"> Description: </label>${questionDescription} </p>
        <p><label class="questionDetail" name="user"> User: </label> ${username} </p>
        <p><label class="questionDetail" name="postedOn"> Posted on: </label>${createdAt}</p>

        <p>
        <label class="questionDetail" name="likes">  (${likes})likes </label>
        <label class="questionDetail" name="dislikes">  (${dislikes})dislikes </label>
        <label class="questionDetail" name="views">  (${views})views </label>
        <label class="questionDetail" name="flags">  (${flags})flags </label>
        </p>


        <button name="like">Like</button>
        <button name="dislike">Dislike</button>
        <button name="flag">Flag</button>

        <p><label class="questionDetail" name="tags"> Tags:</label> ${questionTags} </p>


        <p><label>Your Reply: </label></p>
        <textarea cols="50" rows="14" ></textarea>

        <p><button name="submitReply">Submit</button><p>


    </div>
</div>
</body>
</html>
