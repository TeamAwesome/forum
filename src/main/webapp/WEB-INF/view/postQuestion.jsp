<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Forum - Post Question</title>
    	 <link rel="stylesheet" type="text/css" href="../static/CLEditor1_3_0/jquery.cleditor.css" />
            <script type="text/javascript" src="../static/jquery.min.js"></script>
            <script type="text/javascript" src="../static/CLEditor1_3_0/jquery.cleditor.js"></script>
            <script type="text/javascript" src="../static/CLEditor1_3_0/jquery.cleditor.min.js"></script>
            <script type="text/javascript" src="../javascript/questionValidation.js"></script>

           <script type="text/javascript">
                 $(document).ready(function() {
                   $("#input").cleditor();
                   $("#titleValidationMessage").text("100 Characters Remaining");
                   $("#descriptionValidationMessage").text("500 Characters Remaining");
                 });

                function checkTitle() {
                    var validation = new Validation();
                    var titleValidationMessage = validation.checkTitle($("#questionTitle").val());
                    $("#titleValidationMessage").text(titleValidationMessage);
                }

                function checkDescription() {
                    var validation = new Validation();
                    var descriptionValidationMessage = validation.checkDescription($("#input").val());
                    $("#descriptionValidationMessage").text(descriptionValidationMessage);
                }

                function checkAndSubmit(){
                    var title = $("#questionTitle").val();
                    var description = $("#input").val();
                    var validation = new Validation();
                   if(validation.checkTitleAndDescription(title, description)){
                        $("#qustionForm").submit();
                   } else{
                        checkTitle();
                        checkDescription();
                        $("#validationMessage").text("Title or description is empty or too more characters.");
                   }
                }
               </script>

</head>
<body class="question">
<div class="title">
    <h2>Post Question.</h2>
</div>
<form id="qustionForm" action="../showPostedQuestion" method="post">
    <div class="questionTitle">
        <label class="formLabels"> Title: </label> <input type="text" name="questionTitle" id="questionTitle" onkeyup="checkTitle()"/>
        <div id="titleValidationMessage"></div>
    </div>
    <div class="questionDescription">
        <label class="formLabels"> Description: </label></br>
        <textarea id="input" name="questionDescription" onkeyup="checkDescription()"></textarea>
        <div id="descriptionValidationMessage"></div>
    </div>
    <input type="button" value="Submit" onclick="checkAndSubmit()" id="submitButton"/>
    <div id="validationMessage"></div>
</form>

</body>
</html>
