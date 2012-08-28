<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forum - Your Question</title>
    <style type="text/css">


    #wrap {
        width:70%;
        margin:0 auto;
        max-width: 1260px;
        min-width: 780px;
        background: #fff;
    }

    #left
    {
        float:left;
        width:60%;

    }

    #right
    {
        float:right;
        width:40%;
    }
    </style>

</head>
<body class="question">

<div id ="wrap">

    <div id="left">
        <h2>${questionTitle}</h2>
        <p><textarea rows="15" cols="45" readonly="readonly">${questionDescription} </textarea></p>
        <button name="like">Like</button>
        <button name="dislike">Dislike</button>
        <button name="flag">Flag</button>
        <p><label class="questionDetail" name="tags"> Tags:</label> ${questionTags} </p>
        <p><label>Your Reply: </label></p>
        <textarea cols="50" rows="14" ></textarea>
        <p><button name="submitReply">Submit</button><p>
    </div>

     <div id="right">
        <div><p><label class="questionDetail" name="user"> Posted by </label> ${username} </p></div>
        <div><p><label class="questionDetail" name="postedOn">On: </label>${dateCreatedAt}
        &nbsp<label class="questionDetail" name="postedOn">At: </label>${timeCreatedAt}</p></div>
        <p>
        <label class="questionDetail" name="likes">  (${likes})likes </label>
        <label class="questionDetail" name="dislikes">  (${dislikes})dislikes </label>
        <label class="questionDetail" name="views">  (${views})views </label>
        <label class="questionDetail" name="flags">  (${flags})flags </label>
        </p>
     </div>

</div>
</body>
</html>
