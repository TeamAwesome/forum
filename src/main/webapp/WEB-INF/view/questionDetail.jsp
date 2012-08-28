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
        position: absolute;
        top : 20%;
        right: 10%;
    }


    #questionDescription
    {
        border-style: solid;
        border-width: 1px;
        max-height:300px;
        width: 70%;
        overflow: auto;
    }
    #review
    {
        position: absolute;
    }

    #posted_by
    {
        padding-left : 3em;
    }
    #posted_at
    {
        padding-left :2em;
    }
    #status
    {
        padding-top: 3em;
    }

    #replyTextarea
    {
       resize: none;
    }

    </style>

</head>
<body class="question">

<a href="<c:url value="/"/>">Home</a>

<div id ="wrap">

    <div id="left">
        <h2>${questionTitle}</h2>
      <div id="questionDescription" >
            <p>${questionDescription}</p>
      </div>
        <div id = "review">
            <button name="like">Like</button>
            <button name="dislike">Dislike</button>
            <button name="flag">Flag</button>
            <p><label class="questionDetail" name="tags"> Tags:</label> ${questionTags} </p>
            <p><label>Your Reply: </label></p>
            <textarea id="replyTextarea" cols="50" rows="14" ></textarea>
            <p><button name="submitReply">Submit</button><p>
        </div>
      </div>

      <div id="right">
        <p><label class="questionDetail" id = "posted_by" name="user" > Posted by </label> ${username} </p>
        <p><label class="questionDetail" id = "posted_on" name="postedOn">On: </label>${dateCreatedAt}
        &nbsp<label class="questionDetail" id = "posted_at" name="postedOn">At: </label>${timeCreatedAt}</p>
        <p>
          <div id = "status">
          <label class="questionDetail" name="likes">  (${likes})likes </label>
          <label class="questionDetail" name="dislikes">  (${dislikes})dislikes </label>
          <label class="questionDetail" name="views">  (${views})views </label>
          <label class="questionDetail" name="flags">  (${flags})flags </label>
          </div>
        </p>
      </div>

</div>
</body>
</html>
