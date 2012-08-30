<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Forum - Post Question</title>
              <!-- Skin CSS file -->
              <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/skin.css"/>">
              <!-- Utility Dependencies -->

<style type="text/css">
.validationMessage { color: red; }
</style>

<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css"/>">

</head>
<body class="yui-skin-sam">
<div id="container">
        <div id="header">
            <%@ include file="registerHeader.jsp" %>
        </div>

    <div id="content">
        <div id ="leftPane" >
            <div class="title">
                <h2><center>Post a Question</center></h2>
            </div>
            <form id="questionForm" action="<c:url value="/showPostedQuestion"/>" method="post">
                <div class="questionTitle">
                    <label class="formLabels"> Title: </label> <input type="text" name="questionTitle" id="questionTitle" maxlength="100"/>
                    <div class="validationMessage" id="titleValidationMessage"></div>
                </div>
                <div class="questionDescription" >
                    <label class="formLabels"> Description: </label></br>
                    <textarea id="descriptionEditor" name="questionDescription" rows="20" cols="75" maxlength="500"></textarea>
                    <div class="validationMessage" id="descriptionValidationMessage"></div>
                </div>
                <div id="descriptionValidationMessage"></div>

                <div class="questionTags">
                    <label for="questionTags" class="formLabels">Tags: </label>
                    <input id="questionTags" name="questionTags"></input>
                </div>

                <input type="submit" value="Submit" id="submitButton"/>
            </form>


 </div>

        <div id="rightPane">
            <%@ include file="rightPane.jsp" %>
        </div>

    </div>

</div>

</body>
              <script src="<c:url value="/static/javascript/yahoo-dom-event.js"/>"></script>
              <script src="<c:url value="/static/javascript/jquery-latest.js"/>" type="text/javascript"></script>
              <script src="<c:url value="/static/javascript/jquery-events.js"/>" type="text/javascript"></script>
              <script type="text/javascript" src="<c:url value="/static/javascript/Question.js"/>"></script>
              <script src="<c:url value="/static/javascript/element-min.js"/>"></script>
              <!-- Needed for Menus, Buttons and Overlays used in the Toolbar -->
              <script src="<c:url value="/static/javascript/container_core-min.js"/>"></script>
              <!-- Source file for Rich Text Editor-->
              <script src="<c:url value="/static/javascript/editor-min.js"/>"></script>
              <!---<script src="<c:url value="/static/javascript/simpleeditor-min.js"/>"></script> --->
              <script src="<c:url value="/static/javascript/postQuestionValidator.js"/>"></script>

              <!-- Needed for autocomplete plugin-->
              <script src="<c:url value='/static/jsquery/jquery.js'/>"></script>
              <script src='<c:url value="/static/javascript/tagsAutocomplete.js"/>'></script>
              <script src='<c:url value="/static/javascript/jquery.ui.core.js"/>'></script>
              <script src='<c:url value="/static/javascript/jquery.ui.position.js"/>'></script>
              <script src='<c:url value="/static/javascript/jquery.ui.widget.js"/>'></script>
              <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
              <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
              <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>



</html>

