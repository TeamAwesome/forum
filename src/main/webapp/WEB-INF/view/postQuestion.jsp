<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Forum - Post Question</title>
    	 <link rel="stylesheet" type="text/css" href="./static/CLEditor1_3_0/jquery.cleditor.css" />
            <script type="text/javascript" src="./static/jquery.min.js"></script>
            <script type="text/javascript" src="./static/CLEditor1_3_0/jquery.cleditor.js"></script>
            <script type="text/javascript" src="./static/CLEditor1_3_0/jquery.cleditor.min.js"></script>

           <script type="text/javascript">
                 $(document).ready(function() {
                   $("#input").cleditor();
                 });
               </script>

</head>
<body class="question">
<div class="title">
    <h2>Post Question.</h2>
</div>
<form action="./showPostedQuestion" method="post">
    <div id="questionTitle">
        <label class="formLabels"> Title: </label> <input type="text" name="questionTitle" />
    </div>
    <div id="questionDescription">
        <label class="formLabels"> Description: </label></br>
        <textarea id="input" name="questionDescription"></textarea>
    </div>
    <input type="submit" value="Submit" />
</form>

</body>
</html>
