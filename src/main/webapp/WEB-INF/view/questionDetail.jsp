<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forum - Your Question</title>
    <link rel="stylesheet" type="text/css" href='<c:url value="/static/css/questionDetail.css"/>' />
</head>
<body class="question">

<a href='<c:url value="/"/>'>Home</a>

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
          <label class="questionDetail" name="likes">  (${likes})Likes </label>
          <label class="questionDetail" name="dislikes">  (${dislikes})Dislikes </label>
          <label class="questionDetail" name="views">  (${views})Views </label>
          <label class="questionDetail" name="responses">  (${responses})Responses </label>
          <label class="questionDetail" name="flags">  (${flags})Flags </label>
          </div>
        </p>
      </div>

</div>
</body>
</html>
