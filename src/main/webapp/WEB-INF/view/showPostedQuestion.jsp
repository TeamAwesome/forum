<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forum - Your Question</title>
</head>
<body class="question">
<div class="title">
    <h2>You have successfully entered a question.</h2>
    <div><label class="formLabels">Title:</label>${questionTitle}</div>
    <div>
        <label class="formLabels"> Description: </label>
        ${questionDescription}
    </div>
</div>
</body>
</html>
