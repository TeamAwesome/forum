<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forum - Your Question</title>
</head>
<body class="question">
<div class="title">
    <h2>You have successfully entered a question.</h2>
    <div>
        <p style="font-size:16pt;line-height:20pt;">Title:</p>

        <p>${questionTitle}</p>
    </div>

    <div>
        <p style="font-size:16pt;line-height:20pt;">Description: </p>
        <p>${questionDescription}</p>
    </div>
</div>

</br>
<button name = "returnToHomePage" type = "button">Return to HomePage</button>
</body>
</html>
