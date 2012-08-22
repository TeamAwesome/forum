<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Forum - Post Question</title>
              <!-- Skin CSS file -->
              <link rel="stylesheet" type="text/css" href="/app/static/css/skin.css">
              <!-- Utility Dependencies -->
              <script src="/app/static/javascript/yahoo-dom-event.js"></script>
              <script src="/app/static/javascript/jquery-latest.js" type="text/javascript"></script>
              <script src="/app/static/javascript/jquery-events.js" type="text/javascript"></script>
              <script type="text/javascript" src="/app/static/javascript/questionValidation.js"></script>
              <script src="/app/static/javascript/element-min.js"></script>
              <!-- Needed for Menus, Buttons and Overlays used in the Toolbar -->
              <script src="/app/static/javascript/container_core-min.js"></script>
              <!-- Source file for Rich Text Editor-->
              <script src="/app/static/javascript/simpleeditor-min.js"></script>
              <script src="/app/static/javascript/postQuestionValidator.js"></script>

</head>
<body class="yui-skin-sam">
<div class="title">
    <h2>Post Question.</h2>
</div>
<form id="questionForm" action="./showPostedQuestion" method="post">
    <div class="questionTitle">
        <label class="formLabels"> Title: </label> <input type="text" name="questionTitle" id="questionTitle" maxlength="100"/>
        <div id="titleValidationMessage"></div>
    </div>
    <div class="questionDescription" >
        <label class="formLabels"> Description: </label></br>
        <textarea id="editor" name="editor" rows="20" cols="75" maxlenght="500"></textarea>
        <div id="descriptionValidationMessage"></div>
    </div>
    <input type="button" value="Submit"  id="submitButton"/>
    <div id="validationMessage"></div>
</form>

</body>
</html>
